public class App {
    public static void main(String[] args) {
        CatApiRequest catApiRequest = new CatApiRequest();
        ClientApi client = new ClientApi(catApiRequest);
        String jsonFilePath = "response.json";

        client.performRequest(jsonFilePath);
    }
}
