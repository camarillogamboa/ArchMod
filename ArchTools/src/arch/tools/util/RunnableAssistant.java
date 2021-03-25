package arch.tools.util;

import java.util.Objects;

public final class RunnableAssistant {

    public static final Runnable EMPTY_RUNNABLE = () -> {
    };

    private RunnableAssistant() {
    }

    public static Runnable create(Runnable... runnables) {
        return () -> {
            for (var r : runnables) r.run();
        };
    }

    public static Runnable link(Runnable before, Runnable after) {
        Objects.requireNonNull(before);
        Objects.requireNonNull(after);
        return () -> {
            before.run();
            after.run();
        };
    }
}
