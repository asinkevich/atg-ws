package client;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestBuilderTest {
//    private RequestBuilder requestBuilder;

    @Before
    public void setUp() throws Exception {
//        requestBuilder = new RequestBuilder();
    }

    @Test
    public void shouldCreateRequestAndSetParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("intVal", 7);
        params.put("stringVal", "some string");

        SampleXmlObject request = (SampleXmlObject) RequestBuilder.buildRequest(SampleXmlObject.class, params);

        assertNotNull(request);
        assertEquals(7, request.getIntVal());
        assertEquals("some string", request.getStringVal());
    }

    private class SampleXmlObject extends XmlAnyTypeImpl {
        private int intVal;
        private String stringVal;

        private int getIntVal() {
            return intVal;
        }

        private void setIntVal(int intVal) {
            this.intVal = intVal;
        }

        private String getStringVal() {
            return stringVal;
        }

        private void setStringVal(String stringVal) {
            this.stringVal = stringVal;
        }
    }

}
