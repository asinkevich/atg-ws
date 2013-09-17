package mock.stub;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class TestADBBean implements ADBBean {
    private String name;

    public TestADBBean(String name) {
        this.name = name;
    }

    @Override
    public XMLStreamReader getPullParser(QName qName) throws XMLStreamException {
        return null;
    }

    @Override
    public OMElement getOMElement(QName qName, OMFactory omFactory) throws ADBException {
        return null;
    }

    @Override
    public void serialize(QName qName, XMLStreamWriter xmlStreamWriter) throws XMLStreamException, ADBException {
    }

    @Override
    public void serialize(QName qName, XMLStreamWriter xmlStreamWriter, boolean b) throws XMLStreamException, ADBException {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
