package com.clientserver.app;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        writer.write("Give me information \n");
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        reader.close();
        writer.close();
        clientSocket.close();
    }

}
