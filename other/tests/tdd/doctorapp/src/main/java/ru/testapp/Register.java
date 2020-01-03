package ru.testapp;

import java.util.HashMap;
import java.util.Map;

public class Register {

    Map<String, Object>  register = new HashMap<>();

    public Object get(String name) {
        return register.get(name);
    }

    public void add(String name, Object something) {
        register.put(name, something);
    }
    //add by object name
    public void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public  <T> T get(Class<T> medType) {
        return (T) get(medType.getName());
    }
}
