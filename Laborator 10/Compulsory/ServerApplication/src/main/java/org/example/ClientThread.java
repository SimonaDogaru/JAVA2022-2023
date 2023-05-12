package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "Server received the request : "+request;
                if(request.equals("exit")){
                    socket.close();
                    break;
                }

                if(request.equals("stop")){
                    raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    socket.close();
                    System.exit(1);
                }


                out.println(raspuns);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}

