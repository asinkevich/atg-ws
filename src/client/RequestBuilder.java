package client;

import exception.WSException;
import org.apache.xmlbeans.XmlObject;

import java.util.Map;

public class RequestBuilder {
    public static XmlObject buildRequest(Class<? extends XmlObject> requestDocumentClass, Map<String, Object> params)
            throws WSException {
        XmlObject request;
        try {
//            request = requestDocumentClass.newInstance();
        } catch (Exception e) {
            throw new WSException("Can't instantiate class " + requestDocumentClass, e);
        }
        return null;
    }
}
