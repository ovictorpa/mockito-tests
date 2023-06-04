public class ClientApi {
    private CatApiRequest catApiRequest;
    private boolean requestSuccessful;

    public ClientApi(CatApiRequest catApiRequest) {
        this.catApiRequest = catApiRequest;
    }

    public void performRequest(String jsonFilePath) {
        try {
            catApiRequest.makeApiResponse(jsonFilePath);
            requestSuccessful = true;
        } catch (Exception e) {
            requestSuccessful = false;
        }
    }
    public boolean isRequestSuccessful() {
        return requestSuccessful;
    }
}