package client;

import exception.WSException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.axis2userguide.PostpaidCatalogueWSServiceStub;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WSClient {
    private String stubsPackageName;


    public void callService(String serviceName, String methodName) throws WSException {
        Class stub = getStub(serviceName);
        Class requestClass = getRequestClass(stub, methodName);

        Object stubObject;
        Constructor constructor = null;
        try {
            constructor = stub.getConstructor(String.class);
            stubObject = constructor.newInstance("endpoint");
        } catch (Exception e) {
            throw new WSException(e);
        }


        PostpaidCatalogueWSServiceStub.GetServicesRequest request = new PostpaidCatalogueWSServiceStub.GetServicesRequest();
        request.setChannel("das");
        try {
            PostpaidCatalogueWSServiceStub stub2 = new PostpaidCatalogueWSServiceStub();
//            PostpaidCatalogueWSServiceStub.GetServicesResponse response = stub2.getServices(request);
        } catch (Exception e) {
            throw new WSException(e);
        }
    }

    private Class getRequestClass(Class stub, String methodName) {
        Class requestClass = null;
        for (Class innerClass : stub.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equalsIgnoreCase(methodName + "request")) {
                requestClass = innerClass;
            }
        }
        return requestClass;
    }

    /*
    *
    * else {
            serviceUrl = endPoint + "/" + serviceName;
            auditOn = false;
            timeout = 7500;
        }

        Exception ex = null;
        int numTrys = 0;
        boolean error;
        Stub stub = null;
        boolean slowCall = false;
        int callTime = 0;
        try {
            PerformanceMonitor.startOperation(CALL_SERVICE, serviceName);
            do {
                error = false;
                try {
                    stub = client.init(configContext, serviceUrl);
                    // A bit of insurance should the doStartService call fail
                    if (configContext == null) {
                        configContext = stub._getServiceClient().getServiceContext().getConfigurationContext();
                    }
                    Options axisOptions = stub._getServiceClient().getOptions();
                    axisOptions.setTimeOutInMilliSeconds(timeout);
                    axisOptions.setExceptionToBeThrownOnSOAPFault(throwExceptionOnFault);

                    Class clientClass = client.getClass();
                    Method method = clientClass.getMethod(operation,
                            new Class[] { client.getDataObjectClass(dataObject), stub.getClass() });
                    Calendar START = Calendar.getInstance();
                    response = method.invoke(client, dataObject, stub);
                    Calendar END = Calendar.getInstance();
                    callTime = (int) (END.getTimeInMillis() - START.getTimeInMillis());
                    if (callTime > slowCallThreshold) {
                        slowCall = true;
                    }

                } catch (Exception e) {
                    if (isLoggingError()) {
                        // Actual exception and stack trace should only be logged in calling code
                        logError("Attempt " + numTrys + " to call web service " + serviceUrl + " failed.");
                    }
                    numTrys++;
                    error = true;
                    ex = e;
                }
    * */

    private Class getStub(String serviceName) throws WSException {
        Class stub;
        String stubClassName = getStubsPackageName() + "." + serviceName + "Stub";
        try {
            stub = Class.forName(stubClassName);
        } catch (ClassNotFoundException e) {
            throw new WSException("Class " + stubClassName + " can't be found");
        }
        return stub;
    }

    public String getStubsPackageName() {
        return stubsPackageName;
    }

    public void setStubsPackageName(String stubsPackageName) {
        this.stubsPackageName = stubsPackageName;
    }
}
