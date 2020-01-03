package ru.testapp;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Register {

    Map<String, Object> register = new HashMap<>();
    //Map for injection fields. Object - the name of patient for adding in Map
    Map<Field, Object> fieldsToInject = new HashMap<>();

    public Object get(String name) {
        return register.get(name);
    }

    //work with register only get (add only doctor)
    void add(String name, Object something) {
        if (register.containsKey(name)) {
            throw new RuntimeException();
        }
        //read fields and finding annotation
        for (Field field : something.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                //take from rigister type of field with annotation
                //the fields with inject annotation we can put in special Map
                fieldsToInject.put(field, something);
            }
        }
        register.put(name, something);
    }

    //add by object name
    void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public <T> T get(Class<T> medType) {
        return (T) get(medType.getName());
    }

     void inject() {
        for (Field field : fieldsToInject.keySet()) {
            Object something = fieldsToInject.get(field);
            Object injection = this.get(field.getType());
            field.setAccessible(true);
            try {
                field.set(something, injection);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
