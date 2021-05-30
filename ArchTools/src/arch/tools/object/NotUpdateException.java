package arch.tools.object;

public class NotUpdateException extends Exception{

    public NotUpdateException() {
    }

    public NotUpdateException(String message) {
        super(message);
    }

    public NotUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUpdateException(Throwable cause) {
        super(cause);
    }

    public NotUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
