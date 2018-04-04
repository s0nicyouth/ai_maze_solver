package utils;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Misc {
    public static Pair<RealMatrix, RealVector> readIrisData(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            List<String> lines = new ArrayList<>();
            String line = reader.readLine();
            while (line != null && !line.equals("")) {
                lines.add(line);
                line = reader.readLine();
            }

            RealMatrix mtrx = new Array2DRowRealMatrix(lines.size(), 5);
            RealVector answr = new ArrayRealVector(lines.size());

            for (int i = 0; i < mtrx.getRowDimension(); i++) {
                for (int j = 0; j < mtrx.getColumnDimension(); j++) {
                    String ln = lines.get(i);
                    String[] vals = ln.split(",");
                    double[] vls = new double[5];
                    vls[0] = 1;
                    vls[1] = Double.valueOf(vals[0]);
                    vls[2] = Double.valueOf(vals[1]);
                    vls[3] = Double.valueOf(vals[2]);
                    vls[4] = Double.valueOf(vals[3]);
                    mtrx.setRow(i, vls);
                    answr.setEntry(i, vals[4].equals("Iris-setosa") ? 1 : -1);
                }
            }

            return new Pair<>(mtrx, answr);
        } catch (IOException e) {
            return null;
        }
    }
}
