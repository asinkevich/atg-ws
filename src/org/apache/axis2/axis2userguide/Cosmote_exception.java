
/**
 * Cosmote_exception.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package org.apache.axis2.axis2userguide;

public class Cosmote_exception extends java.lang.Exception{

    private static final long serialVersionUID = 1379239519675L;
    
    private org.apache.axis2.axis2userguide.PostpaidCatalogueWSServiceStub.PostpaidCatalogue_exception faultMessage;

    
        public Cosmote_exception() {
            super("Cosmote_exception");
        }

        public Cosmote_exception(java.lang.String s) {
           super(s);
        }

        public Cosmote_exception(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public Cosmote_exception(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.apache.axis2.axis2userguide.PostpaidCatalogueWSServiceStub.PostpaidCatalogue_exception msg){
       faultMessage = msg;
    }
    
    public org.apache.axis2.axis2userguide.PostpaidCatalogueWSServiceStub.PostpaidCatalogue_exception getFaultMessage(){
       return faultMessage;
    }
}
    