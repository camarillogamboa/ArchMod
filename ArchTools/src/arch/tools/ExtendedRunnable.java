package arch.tools;

import java.util.Objects;

@FunctionalInterface
public interface ExtendedRunnable extends Runnable {

    ExtendedRunnable EMPTY = () -> {
    };

    default ExtendedRunnable andThen(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return () -> {
            run();
            runnable.run();
        };
    }

    static ExtendedRunnable wrap(Runnable... runnables) {
        return () -> {
            for (var runnable : runnables) if (runnable != null) runnable.run();
        };
    }

    static ExtendedRunnable update(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return runnable instanceof ExtendedRunnable ? (ExtendedRunnable) runnable : runnable::run;
    }

}
