package manager;

import exception.WSException;
import rom.cosmote.postpaid.webservice.postpaidcatalogue.GetServicesRequestDocument;
import rom.cosmote.postpaid.webservice.postpaidcatalogue.GetServicesResponseDocument;

import static rom.cosmote.postpaid.webservice.postpaidcatalogue.GetServicesRequestDocument.*;

public class PostpaidCatalogueManager extends DefaultManager {
    public void getServices() throws WSException {
        GetServicesRequestDocument requestDocument = GetServicesRequestDocument.Factory.newInstance();
        GetServicesRequest request = requestDocument.addNewGetServicesRequest();
        request.setChannel("atg");
        GetServicesResponseDocument response = (GetServicesResponseDocument) callService(requestDocument, "getServices");
        System.out.println(response);
    }

}
