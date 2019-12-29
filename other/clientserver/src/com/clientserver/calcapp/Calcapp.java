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
        Phone phone = new Phone(port);
        System.out.println("Started server with " + operation + " on " + port);
        while(true) {
            phone.accept(); // create socket and thread IO
            String a = phone.readLine();
            String b = phone.readLine();
            int result = calculate(operation, a, b);
            String msg = a + " " + operation + " " + b + " = " + result;
            phone.writeLine(msg);
            System.out.println("Accepted: " + msg);
            phone.close();
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

    private int calculate(String operation, String a, String b) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch (operation) {
            case "-" : return  x - y;
            case "*" : return  x * y;
            case "/" : return  x / y;
            case "+" :
            default:  return  x + y;
        }


    }
}
