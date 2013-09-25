package mock.stub;

public class TestServiceStub {
    private String endPoint;

    public TestServiceStub() {
    }

    public TestServiceStub(String endPoint) {
        this.endPoint = endPoint;
    }

    public StubResponse getServices(StubRequest request) {
        StubResponse stubResponse = new StubResponse();
        stubResponse.setResponseCode(request.getChannel());
        return stubResponse;
    }
}
