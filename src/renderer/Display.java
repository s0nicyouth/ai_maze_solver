package renderer;

import javax.swing.*;
import java.awt.*;

public class Display {

    private static final int SIDE = 1000;

    private JFrame mMainFrame = new JFrame("AiSolver");
    private Canvas mCanvas = new Canvas();

    public Display() {
        mMainFrame.setSize(SIDE, SIDE);
        mMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mMainFrame.setResizable(false);
        mMainFrame.setVisible(true);
        mMainFrame.setLocationRelativeTo(null);

        mCanvas.setPreferredSize(new Dimension(SIDE, SIDE));
        mCanvas.setMaximumSize(new Dimension(SIDE, SIDE));
        mCanvas.setMinimumSize(new Dimension(SIDE, SIDE));

        mMainFrame.add(mCanvas);
        mMainFrame.pack();
    }

    public Canvas getCanvas() {
        return mCanvas;
    }
}
