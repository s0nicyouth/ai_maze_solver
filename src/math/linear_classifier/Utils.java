package math.linear_classifier;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Utils {

    public interface LossFunction {
        double loss(double gap);
    }

    public static double computeAnswer(RealVector weights, RealVector features) {
        assert(weights.getDimension() == features.getDimension());

        RealVector mult = weights.ebeMultiply(features);
        double result = 0;
        for (int i = 0; i < weights.getDimension(); i++)
            result += mult.getEntry(i);

        return result;
    }

    public static double computeGap(double answer, double expected) {
        return answer * expected;
    }

    public static double computeQualityFunction(RealMatrix objects, RealVector answers, RealVector weights, LossFunction loss) {
        double error = 0;
        for (int object = 0; object < objects.getRowDimension(); object++) {
            double answer = computeAnswer(weights, objects.getRowVector(object));
            double gap = computeGap(answer, answers.getEntry(object));

            error += loss.loss(gap);
        }

        return error / objects.getRowDimension();
    }

    public static double computeExponentialQualityFunction(RealMatrix objects, RealVector answers, RealVector weights) {
        return computeQualityFunction(objects, answers, weights, gap -> Math.exp(-1 * gap));
    }

    public RealVector gradientDescentExponentialFunction(RealMatrix objects, RealVector answers) {
        return gradientDescentExponentialFunction(objects, answers, 0.05);
    }

    public static RealVector gradientDescentExponentialFunction(RealMatrix objects, RealVector answers, double step) {
        RealVector weights = new ArrayRealVector(objects.getColumnDimension());
        for (int i = 0; i < weights.getDimension(); i++)
            weights.setEntry(i, Math.random());

        while (true) {
            RealVector grad = new ArrayRealVector(weights.getDimension());
            double gradElem = 0;
            for (int wN = 0; wN < weights.getDimension(); wN++) {
                for (int object = 0; object < objects.getRowDimension(); object++) {
                    double answer = computeAnswer(weights, objects.getRowVector(object));
                    double gap = computeGap(answer, answers.getEntry(object));
                    double exp = Math.exp(-1 * gap);

                    gradElem += exp * objects.getRowVector(object).getEntry(wN) * answers.getEntry(object);
                }

                gradElem = gradElem / objects.getRowDimension();
                gradElem *= -1;

                grad.setEntry(wN, gradElem);
            }

            weights = weights.subtract(grad.mapMultiply(step));
            System.out.println(computeExponentialQualityFunction(objects, answers, weights));
        }
    }
}
