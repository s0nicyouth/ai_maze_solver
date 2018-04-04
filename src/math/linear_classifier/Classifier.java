package math.linear_classifier;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Classifier {
    private RealMatrix mObjects;
    private RealVector mAnswers;
    private RealVector mWeights;

    public void fit(RealMatrix objects, RealVector answers) {
        mObjects = objects;
        mAnswers = answers;



        Utils.gradientDescentExponentialFunction(objects, answers, 0.00001);
    }
}
