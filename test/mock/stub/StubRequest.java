package mock.stub;

import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;

public class StubRequest extends XmlAnyTypeImpl {
    private String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
