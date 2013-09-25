package client;

import exception.WSException;
import org.apache.xmlbeans.XmlObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class WSClient {
    private String stubsPackageName;

    public XmlObject callService(String serviceName, String methodName, String endPoint, XmlObject request) throws WSException {
        Class stubClass = getStub(serviceName);
        Object serviceStub = getServiceStub(endPoint, stubClass);
        Method serviceMethod = getMethodForInvokingWS(methodName, stubClass, request.getClass());

        return callService(serviceName, endPoint, serviceStub, serviceMethod, request);
    }

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

    private Object getServiceStub(String endPoint, Class stubClass) throws WSException {
        Object stubObject;
        Constructor constructor;
        try {
            constructor = stubClass.getConstructor(String.class);
            stubObject = constructor.newInstance(endPoint);
        } catch (Exception e) {
            throw new WSException(e);
        }
        return stubObject;
    }

    private Method getMethodForInvokingWS(String methodName, Class stubClass, Class requestClass) throws WSException {
        Method method;
        try {
            method = stubClass.getMethod(methodName, requestClass);
        } catch (NoSuchMethodException e) {
            throw new WSException("Can't find method " + methodName + "("
                    + requestClass.getSimpleName() + ") for " + stubClass);
        }
        return method;
    }

    private Object initRequest(Map<String, Object> requestParams, Class requestClass) throws WSException {
        Object request;
        String methodName = null;
        Object paramValue = null;
        try {
            request = requestClass.newInstance();
            for (String paramName : requestParams.keySet()) {
                paramValue = requestParams.get(paramName);
                methodName = "set" + capitalize(paramName);
                Method m = requestClass.getMethod(methodName, paramValue.getClass());
                m.invoke(request, paramValue);
            }
        } catch (NoSuchMethodException e) {
            throw new WSException("Can' find method " + methodName
                    + "(" + paramValue.getClass().getSimpleName() + ") for " + requestClass);
        } catch (Exception e) {
            throw new WSException(e);
        }
        return request;
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private XmlObject callService(String serviceName, String endPoint, Object serviceStub, Method serviceMethod, Object request) throws WSException {
        try {
            return  (XmlObject) serviceMethod.invoke(serviceStub, request);
        } catch (InvocationTargetException e) {
            throw new WSException("Web service " + serviceName + " is unavailable at " + endPoint);
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
