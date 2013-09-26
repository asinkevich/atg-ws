import client.WSClient;
import exception.WSException;
import manager.DefaultManager;
import manager.PostpaidCatalogueManager;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws WSException {
        String packageName = "ro.cosmote.integration.ws.client";
        String serviceName = "PostpaidCatalogueWSService";
        String endPoint = "http://localhost:8088/postpaid";

        WSClient wsClient = new WSClient();
        wsClient.setStubsPackageName(packageName);

        PostpaidCatalogueManager manager = new PostpaidCatalogueManager();
        manager.setServiceName(serviceName);
        manager.setWsClient(wsClient);
        manager.setWsEndpoint(endPoint);

        manager.getServices();
    }
}
