package arch.tools;

public final class RunnableException extends Exception implements ExtendedRunnable {

    private final ExtendedRunnable runnable;

    public RunnableException(ExtendedRunnable runnable) {
        super();
        this.runnable = runnable;
    }

    public RunnableException(String message, ExtendedRunnable runnable) {
        super(message);
        this.runnable = runnable;
    }

    public RunnableException(String message, Throwable cause, ExtendedRunnable runnable) {
        super(message, cause);
        this.runnable = runnable;
    }

    public RunnableException(Throwable cause, ExtendedRunnable runnable) {
        super(cause);
        this.runnable = runnable;
    }

    public RunnableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExtendedRunnable runnable) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.runnable = runnable;
    }

    @Override
    public void run() {
        if (runnable != null) runnable.run();
    }
}
