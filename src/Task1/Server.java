package Task1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        int port = 25565; // Порт, який прослуховує сервер

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущено на порту " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Отримано: " + inputLine);
                        out.println("Вiдповiдь: " + inputLine); // Відправляємо відповідь клієнту
                    }
                } catch (IOException e) {
                    System.out.println("Помилка при обробцi клiєнта: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при запуску сервера: " + e.getMessage());
        }
    }
}
