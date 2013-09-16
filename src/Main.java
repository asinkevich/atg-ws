import client.WSClient;
import exception.WSException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.axis2userguide.PostpaidCatalogueWSServiceStub;

public class Main {
    public static void main(String[] args) throws WSException {
//        Class c = PostpaidCatalogueWSServiceStub.class;
        String packageName = "org.apache.axis2.axis2userguide";
        String serviceName = "PostpaidCatalogueWSService";
        String operationName = "getServices";


        WSClient wsClient = new WSClient();
        wsClient.setStubsPackageName(packageName);

        wsClient.callService(serviceName, operationName);
    }
}
