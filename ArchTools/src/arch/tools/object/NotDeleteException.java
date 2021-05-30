package arch.tools.object;

public class NotDeleteException extends Exception{

    public NotDeleteException() {
    }

    public NotDeleteException(String message) {
        super(message);
    }

    public NotDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDeleteException(Throwable cause) {
        super(cause);
    }

    public NotDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
