package exception;

import org.apache.axis2.AxisFault;

public class WSException extends Exception {
    public WSException(String str) {
        super(str);
    }

    public WSException(String s, Exception e) {
        super(s, e);
    }

    public WSException(Exception e) {
        super(e);
    }
}
