package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        int port = 25565;

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            byte[] receiveData = new byte[1024];

            System.out.println("Сервер запущено на порту " + port);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Отримано: " + message);
            }
        } catch (Exception e) {
            System.out.println("Помилка сервера: " + e.getMessage());
        }
    }
}
