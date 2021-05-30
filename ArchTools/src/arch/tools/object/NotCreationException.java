package arch.tools.object;

public class NotCreationException extends Exception{

    public NotCreationException() {
    }

    public NotCreationException(String message) {
        super(message);
    }

    public NotCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCreationException(Throwable cause) {
        super(cause);
    }

    public NotCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
