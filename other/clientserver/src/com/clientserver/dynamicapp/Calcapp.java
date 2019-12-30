package com.clientserver.dynamicapp;

public class Calcapp {

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage : \r\n"
                + " java Calcapp server 8000 2 / \r\n" //2 - how many pots will create
                + " java Calcapp client 127.0.0.1 8000 45 35");
            return;
        }
        Calcapp calcapp = new Calcapp();
        if(args[0].equals("server")) {
            calcapp.runServer(args[1], args[2], args[3]);
        }
        if(args[0].equals("client")) {
            calcapp.runClient(args[1], args[2], args[3], args[4]);
        }

    }

    //at the same time waiting for  clients
    private void runServer(String port, String threadsCount, String operation) {
        int threads = Integer.parseInt(threadsCount);
        Phone phone = new Phone(port); // create serverSocket
        System.out.println("Started server with " + operation + " on " + port);

        for(int i = 0; i < threads; i++) {
            new Thread(new ServerPhone(new Phone(phone), operation)).start();
        }
    }

    private void runClient(String ip, String port, String a, String b) {
        Phone phone = new Phone(ip, port);
        phone.writeLine(a);
        phone.writeLine(b);
        String answer = phone.readLine();
        System.out.println(answer);
        phone.close();
    }

}
