package ru.testapp;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Register {

    Map<String, Object>  register = new HashMap<>();

    public Object get(String name) {
        return register.get(name);
    }

    public void add(String name, Object something) {
        if(register.containsKey(name)) {
            throw new RuntimeException();
        }
        //read fields and finding annotation
        for(Field field : something.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)) {
                //take from rigister type of field with annotation
                Object injection = this.get(field.getType());
                field.setAccessible(true);
                try {
                    field.set(something, injection);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
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
