package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public GameServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }
    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer();
    }
}