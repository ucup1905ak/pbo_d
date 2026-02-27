package pbo_1;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int portNumber = 12345;
        System.out.println("Server listening on port " + portNumber);

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                new Thread(() -> { // handle each client in a new thread
                    try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    ) {
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Received: " + inputLine);
                            out.println("Echo: " + inputLine);
                            if (inputLine.equals("EXIT")) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try { clientSocket.close(); } catch (IOException e) {}
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}