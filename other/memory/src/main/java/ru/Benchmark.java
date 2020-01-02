package ru;

import java.util.ArrayList;

public class Benchmark implements BenchmarkMBean {
    private volatile int size = 5;
    private static ArrayList<String> arrayList = new ArrayList<>();


    void run() throws Exception {
        while (true) {
            int localSize = size;
            for (int i = 0; i < localSize; i++) {
                arrayList.add(String.valueOf(new char[0]));
            }
            arrayList.remove(arrayList.size() - 1);
            System.out.println("Loop");
            Thread.sleep(1);
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}