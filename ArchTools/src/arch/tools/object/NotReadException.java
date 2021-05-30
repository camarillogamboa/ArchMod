package arch.tools.object;

public class NotReadException extends Exception{

    public NotReadException() {
    }

    public NotReadException(String message) {
        super(message);
    }

    public NotReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotReadException(Throwable cause) {
        super(cause);
    }

    public NotReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
