package client;

import mock.stub.StubRequest;
import mock.stub.StubResponse;
import org.junit.Before;
import org.junit.Test;

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
        StubRequest request = new StubRequest();
        request.setChannel("atg_channel");

//        StubResponse response = (StubResponse) wsClient.callService(
//                "TestService", "getServices", "http://localhost:8088/testService", request);
//        assertEquals("atg_channel", response.getResponseCode());
    }
}
