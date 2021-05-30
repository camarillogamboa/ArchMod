package arch.tools;

import java.util.function.BooleanSupplier;

public final class ThreadLauncher {

    private ThreadLauncher() {
    }

    public static Thread launchThread(long initDelay, long loopDelay, BooleanSupplier condition, ExtendedRunnable loopAction) {
        return launchThread(() -> {
            sleep(initDelay);
            while (condition.getAsBoolean()) {
                loopAction.run();
                sleep(loopDelay);
            }
        });
    }

    public static Thread launchThread(ExtendedRunnable runnable) {
        var thread = createThread(runnable);
        thread.start();
        return thread;
    }

    public static Thread createThread(ExtendedRunnable runnable) {
        return new Thread(runnable);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
