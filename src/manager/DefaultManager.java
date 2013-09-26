package manager;

import client.WSClient;
import exception.WSException;
import org.apache.xmlbeans.XmlObject;
import ro.cosmote.integration.ws.client.PostpaidCatalogueWSService.PostpaidCatalogueWSServiceStub;

public class DefaultManager {
    private WSClient wsClient;
    private String serviceName;
    private String wsEndpoint;

    protected XmlObject callService(XmlObject request, String methodName) throws WSException {
        return getWsClient().callService(getServiceName(), methodName, getWsEndpoint(), request);
    }

    public WSClient getWsClient() {
        return wsClient;
    }

    public void setWsClient(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public String getWsEndpoint() {
        return wsEndpoint;
    }

    public void setWsEndpoint(String wsEndpoint) {
        this.wsEndpoint = wsEndpoint;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
