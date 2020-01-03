package ru.testapp;

public class Doctor {

    private Register register = new Register();

    public Doctor register(Object something) {
        register.add(something);
        return this;
    }

    public Register build() {
        register.inject();
        return register;
    }

}
