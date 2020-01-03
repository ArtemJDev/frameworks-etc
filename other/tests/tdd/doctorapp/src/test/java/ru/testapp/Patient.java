package ru.testapp;

//test injection
public class Patient {

    @Inject
    Pinicilin pinicilin;

    public Pinicilin getPinicilin() {
        return pinicilin;
    }
}
