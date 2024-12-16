package Task1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        String hostName = "localhost"; // Адреса сервера
        int port = 25565; // Порт сервера

        try (Socket socket = new Socket(hostName, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Вiдповiдь сервера: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.out.println("Не вдалося пiдключитися до сервера: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка вводу/виводу: " + e.getMessage());
        }
    }
}
