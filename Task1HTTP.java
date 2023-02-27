package module13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class Task1HTTP {

   public void postUrl (User user) throws URISyntaxException, IOException, InterruptedException {
      String newUser = new Gson().toJson(user);
      String uri = "https://jsonplaceholder.typicode.com/users";
      HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
              .headers("Content-Type", "application/json")
              .POST(HttpRequest.BodyPublishers.ofFile(Path.of(newUser)))
              .build();
      HttpClient httpClient = HttpClient.newBuilder()
              .version(HttpClient.Version.HTTP_1_1)
              .build();
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
   }

   public void sendPut() throws IOException, InterruptedException, URISyntaxException {
      String uri = "https://jsonplaceholder.typicode.com/users";
      HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
              .headers("Content-Type", "application/json")
              .PUT(HttpRequest.BodyPublishers.noBody())
              .build();
      HttpClient httpClient = HttpClient.newBuilder()
              .version(HttpClient.Version.HTTP_1_1)
              .build();
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
   }

   public void sendDelete() throws IOException, InterruptedException, URISyntaxException {
      String uri = "https://jsonplaceholder.typicode.com/users";
      HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))

              .headers("Content-Type", "application/json")
              .DELETE()
              .build();
      HttpClient httpClient = HttpClient.newBuilder()
              .version(HttpClient.Version.HTTP_1_1)
              .build();
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
   }
}

