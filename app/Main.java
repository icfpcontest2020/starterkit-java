import java.net.*;
import java.net.http.*;

class Main {
    public static void main(String[] args) throws Exception {
        var serverUrl = args[0];
        var playerKey = args[1];

        System.out.println("ServerUrl: " + serverUrl + "; PlayerKey: " + playerKey);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "?player_key=" + playerKey))
                .build();

        var response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.discarding());

        var status = response.statusCode();

        if (status != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed to send request. Status code: " + status);
        }
    }
}
