package arch.tools.util;

public final class RunnableException extends Exception implements Runnable {

    private final Runnable runnable;

    public RunnableException(Runnable runnable) {
        super();
        this.runnable = runnable;
    }

    public RunnableException(String message, Runnable runnable) {
        super(message);
        this.runnable = runnable;
    }

    public RunnableException(String message, Throwable cause, Runnable runnable) {
        super(message, cause);
        this.runnable = runnable;
    }

    public RunnableException(Throwable cause, Runnable runnable) {
        super(cause);
        this.runnable = runnable;
    }

    public RunnableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Runnable runnable) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.runnable = runnable;
    }

    @Override
    public void run() {
        if (runnable != null) runnable.run();
    }
}
