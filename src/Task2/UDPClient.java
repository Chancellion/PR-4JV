package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        String serverAddress = "localhost";
        int port = 25565;

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress IPAddress = InetAddress.getByName(serverAddress);

            while (true) {
                System.out.print("Введiть повiдомлення: ");
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                clientSocket.send(sendPacket);
            }
        } catch (Exception e) {
            System.out.println("Помилка клiєнта: " + e.getMessage());
        }
        
    }
}
