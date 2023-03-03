package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class Task3HTTP {
    private static final Gson Gson = new Gson();
    public static List<UserCompleted> sendGetById(int id) throws IOException, InterruptedException, URISyntaxException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id + "/todos";
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<UserCompleted> userCompleteds = Gson.fromJson(httpResponse.body(), new TypeToken<List<UserCompleted>>() {
        }.getType());
        return userCompleteds.stream()
                .filter(complet -> complet.getCompleted().contains("false"))
                .collect(Collectors.toList());
    }
}
