package exception;

public class WSException extends Exception {
    public WSException(String s) {
        super(s);
    }

    public WSException(String s, Exception e) {
        super(s, e);
    }

    public WSException(Exception e) {
        super(e);
    }
}
