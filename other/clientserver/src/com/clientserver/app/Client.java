package com.clientserver.app;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);

//        System.out.println(clientSocket.getInputStream().read());


        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String test = reader.readLine();
        System.out.println(test);

        clientSocket.close();
    }

}
