package com.clientserver.calcapp;

public class Calcapp {

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage : \n"
                + " java Calcapp server 8000 / \n"
                + " java Calcapp client 127.0.0.1 8000 45 35");
            return;
        }
        Calcapp calcapp = new Calcapp();
        if(args[0].equals("server")) {
            calcapp.runServer(args[1], args[2]);
        }
        if(args[0].equals("client")) {
            calcapp.runClient(args[1], args[2], args[3], args[4]);
        }

    }

    private void runServer(String port, String operation) {

    }

    private void runClient(String ip, String port, String a, String b) {

    }
}
