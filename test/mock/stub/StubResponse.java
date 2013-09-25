package mock.stub;

import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;

public class StubResponse extends XmlAnyTypeImpl {
    private String responseCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
