package ru;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class App {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru:type=ru.Benchmark");
        Benchmark mbean = new Benchmark();
        mbs.registerMBean(mbean, name);

        mbean.setSize(15);
        mbean.run();
    }

}