package Task3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class HttpPostExample {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString("{\"name\":\"John\", \"age\":30}"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Статус код: " + response.statusCode());
            System.out.println("Заголовки: " + response.headers());
            System.out.println("Тiло вiдповiдi: " + response.body());
        } catch (Exception e) {
            System.out.println("Помилка при виконаннi POST-запиту: " + e.getMessage());
        }
    }
}
