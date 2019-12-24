package com.clientserver.app;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server running...");

//        clientSocket.getOutputStream().write(64);//send byte to client
//        clientSocket.getOutputStream().write("<h2>Hello</h2>".getBytes());//send text to client

        int client = 0;

        while(true) {
            Socket clientSocket = serverSocket.accept();//create clientSocket
            System.out.println("Client accepted " + client++);

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            String request = reader.readLine();
            String response =  "#" + client + ": your message length is " + request.length() + "\n";
            writer.write(response);
            writer.flush();


            //for client
//            outputStream.write("HTTP/1.0 200 OK\n "
//                + "Content-type: text/html\n"
//                + "\n"
//                + "<h2>Hello</h2>");

            reader.close();
            writer.close();
            clientSocket.close();
        }

    }


}
