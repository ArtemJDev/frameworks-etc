package com.clientserver.threadapp;

public class ServerPhone implements Runnable {

    Phone phone;
    String operation;

    public ServerPhone(Phone phone, String operation) {
        this.phone = phone;
        this.operation = operation;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Waiting for client...");
            phone.accept(); // create socket and thread IO
            String a = phone.readLine();
            String b = phone.readLine();
            int result = calculate(operation, a, b);
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String msg = a + " " + operation + " " + b + " = " + result;
            phone.writeLine(msg);
            System.out.println("Accepted: " + msg);
            phone.close();
        }
    }

    private int calculate(String operation, String a, String b) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch (operation) {
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            case "+":
            default:
                return x + y;
        }
    }
}
