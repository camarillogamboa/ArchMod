package arch.tools.util;

import java.util.function.BooleanSupplier;

public final class ThreadLauncher {

    private ThreadLauncher() {
    }

    public static Thread launchThread(long initDelay, long loopDelay, BooleanSupplier condition, Runnable loopAction) {
        return launchThread(() -> {
            sleep(initDelay);
            while (condition.getAsBoolean()) {
                loopAction.run();
                sleep(loopDelay);
            }
        });
    }

    public static Thread launchThread(Runnable runnable) {
        var thread = createThread(runnable);
        thread.start();
        return thread;
    }

    public static Thread createThread(Runnable runnable) {
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
