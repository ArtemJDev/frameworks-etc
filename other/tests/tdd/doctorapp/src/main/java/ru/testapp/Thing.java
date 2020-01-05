package ru.testapp;

import java.util.ArrayList;
import java.util.List;

public class Thing {

    private String name;

    private List<Injection> injections = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Injection> getInjections() {
        return injections;
    }

    public void setInjections(List<Injection> injections) {
        this.injections = injections;
    }
}
