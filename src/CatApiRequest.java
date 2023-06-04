import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class CatApiRequest {

    String apiUrl = "https://api.thecatapi.com/v1/categories";

    public void makeApiResponse(String jsonFilePath) {
        try {
            URI uri = new URI(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                FileWriter fileWriter = new FileWriter(jsonFilePath);
                fileWriter.write(response.toString());
                fileWriter.close();

                System.out.println("Response saved to " + jsonFilePath);
            } else {
                System.out.println("Request error. Response code: " + responseCode);
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
