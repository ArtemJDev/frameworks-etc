package ru.testapp;

import javax.xml.bind.annotation.XmlAttribute;

public class Injection {

    private String name;
    private String cure;

    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public String getName() {
        return name;
    }
    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
}
