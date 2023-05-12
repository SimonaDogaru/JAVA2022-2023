package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            Scanner scanner = new Scanner(System.in);
            String request = null;
            while (true)
            {
                System.out.print("Give a command: ");
                request = scanner.nextLine();

                out.println(request);
                out.flush();
                if(request.equals("exit")){
                    System.out.println("Client disconect");
                    break;
                }
                String response = in.readLine ();
                System.out.println(response);
                if(request.equals("stop")){
                    break;
                }

            }
            socket.close();
            scanner.close();
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
