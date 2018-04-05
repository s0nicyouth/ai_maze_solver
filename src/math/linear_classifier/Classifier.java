package math.linear_classifier;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Classifier {
    private RealMatrix mObjects;
    private RealVector mAnswers;
    private RealVector mWeights;

    public void fit(RealMatrix objects, RealVector answers) {
        mObjects = objects;
        mAnswers = answers;



        mWeights = Utils.gradientDescentExponentialFunction(objects, answers);
    }

    public double predict(RealVector object) {
        return Math.signum(Utils.computeAnswer(mWeights, object));
    }
}
