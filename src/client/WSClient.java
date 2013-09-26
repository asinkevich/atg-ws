package client;

import exception.WSException;
import org.apache.xmlbeans.XmlObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WSClient {
    private String stubsPackageName;

    /**
     * @param webServiceName name from WSDL file (line 'service name="xxx"')
     */
    public XmlObject callService(String webServiceName, String methodName, String endPoint, XmlObject request) throws WSException {
        Class stubClass = getWebServiceStubClass(webServiceName);
        Object serviceStub = getServiceStub(endPoint, stubClass);
        Method serviceMethod = getMethodForInvokingWS(methodName, stubClass, request.getClass());

        return callService(webServiceName, endPoint, serviceStub, serviceMethod, request);
    }

    private Class getWebServiceStubClass(String webServiceName) throws WSException {
        String stubClassName = getStubsPackageName() + "." + webServiceName + "." + webServiceName + "Stub";
        try {
            return Class.forName(stubClassName);
        } catch (ClassNotFoundException e) {
            throw new WSException("Class " + stubClassName + " can't be found");
        }
    }

    private Object getServiceStub(String endPoint, Class stubClass) throws WSException {
        try {
            Constructor constructor = stubClass.getConstructor(String.class);
            return constructor.newInstance(endPoint);
        } catch (Exception e) {
            throw new WSException(e);
        }
    }

    private Method getMethodForInvokingWS(String methodName, Class stubClass, Class requestClass) throws WSException {
        try {
            return stubClass.getMethod(methodName, requestClass.getInterfaces()[0]);
        } catch (NoSuchMethodException e) {
            throw new WSException("Can't find method " + methodName + "("
                    + requestClass.getSimpleName() + ") for " + stubClass);
        }
    }

    private XmlObject callService(String serviceName, String endPoint, Object serviceStub, Method serviceMethod, Object request) throws WSException {
        try {
            return  (XmlObject) serviceMethod.invoke(serviceStub, request);
        } catch (InvocationTargetException e) {
            throw new WSException("Web service " + serviceName + " is unavailable at " + endPoint, e);
        } catch (IllegalAccessException e) {
            throw new WSException(e);
        }
    }

    public String getStubsPackageName() {
        return stubsPackageName;
    }

    public void setStubsPackageName(String stubsPackageName) {
        this.stubsPackageName = stubsPackageName;
    }
}
