package arch.tools.desingpattern.layeredcontrol;

import arch.tools.ExtendedRunnable;

import java.util.Objects;

public final class ClosingOrder implements ExtendedRunnable {

    public static final ClosingOrder DEFAULT_CLOSE_ORDER = new ClosingOrder(ExtendedRunnable.EMPTY, true);

    private final Runnable closeAction;
    private final boolean allowed;
    private boolean consumed;

    public ClosingOrder(Runnable closingAction, boolean allowed) {
        this.closeAction = Objects.requireNonNull(closingAction);
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
