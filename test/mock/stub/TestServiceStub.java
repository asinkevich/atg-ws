package mock.stub;

import org.apache.axis2.databinding.ADBBean;

public class TestServiceStub {
    private String endPoint;

    public TestServiceStub() {
    }

    public TestServiceStub(String endPoint) {
        this.endPoint = endPoint;
    }

    public ADBBean getServices(GetServicesRequest request) {
        return new TestADBBean(request.getChannel());
    }

    public static class GetServicesRequest {
        private String channel;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
    }
}
