package client;

import mock.stub.TestADBBean;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WSClientTest {
    private WSClient wsClient;

    @Before
    public void setUp() throws Exception {
        wsClient = new WSClient();
        wsClient.setStubsPackageName("mock.stub");
    }

    @Test
    public void shouldLoadStubClasses() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "atg");

        TestADBBean response = (TestADBBean) wsClient.callService(
                "TestService", "getServices", "http://localhost:8088/testService", params);
        assertEquals("atg", response.getName());
    }
}
