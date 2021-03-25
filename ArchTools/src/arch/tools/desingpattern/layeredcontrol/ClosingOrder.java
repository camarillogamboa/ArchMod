package arch.tools.desingpattern.layeredcontrol;

import arch.tools.util.RunnableAssistant;

import java.util.Objects;

public final class ClosingOrder implements Runnable {

    public static final ClosingOrder DEFAULT_CLOSE_ORDER = new ClosingOrder(RunnableAssistant.EMPTY_RUNNABLE, true);

    private final Runnable closeAction;
    private final boolean allowed;
    private boolean consumed;

    public ClosingOrder(Runnable closeAction, boolean allowed) {
        this.closeAction = Objects.requireNonNull(closeAction);
        this.allowed = allowed;
        this.consumed = false;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public boolean isConsumed() {
        return consumed;
    }

    @Override
    public void run() {
        if (allowed && !consumed) {
            closeAction.run();
            consumed = true;
        }
    }

}
