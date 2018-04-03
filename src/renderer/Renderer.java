package renderer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Renderer {

    private Engine mEngine;
    private AtomicBoolean mEnd = new AtomicBoolean(false);
    private Executor mExecutor = Executors.newSingleThreadExecutor();
    private Display mDisplay;

    private long mLastTick;

    public Renderer(Engine engine, Display display) {
        mEngine = engine;
        mDisplay = display;

        mLastTick = System.nanoTime();

        mExecutor.execute(() -> {
            while (!mEnd.get()) {
                mEngine.tick(mDisplay.getCanvas(),System.nanoTime() - mLastTick);
                mEngine.render(mDisplay.getCanvas());
                try {
                    // Dirty hack to avoid flickering
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
