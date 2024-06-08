package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    private static final int PORT = 5555;
    private static final String REPONSE_STRING = "HTTP/1.1 200 OK\r\nContent-Lenght: 0\r\n\r\n";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            server.setReuseAddress(true);
            System.out.println("Server listening in port: " + PORT);
            while (true) {
                try (Socket client = server.accept()) {
                    byte[] data = new byte[1024];
                    int nbytes = client.getInputStream().read(data);
                    System.out.println("Server recived: " + nbytes + " bytes");
                    client.getOutputStream().write(REPONSE_STRING.getBytes(StandardCharsets.UTF_8));
                    client.close();
                } catch (Exception e) {
                    System.err.println("[ERROR] Client Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Could not create the server: " + e.getMessage());
            System.exit(1);
        }
    }
}
