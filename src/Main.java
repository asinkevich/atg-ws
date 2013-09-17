import client.WSClient;
import exception.WSException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws WSException {
        String packageName = "org.apache.axis2.axis2userguide";
        String serviceName = "PostpaidCatalogueWSService";
        String operationName = "getServices";
        String endPoint = "http://localhost:8088";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "atg");


        WSClient wsClient = new WSClient();
        wsClient.setStubsPackageName(packageName);

        wsClient.callService(serviceName, operationName, endPoint, params);
    }
}
