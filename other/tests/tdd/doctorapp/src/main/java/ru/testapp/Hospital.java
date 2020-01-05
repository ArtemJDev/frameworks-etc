package ru.testapp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {

    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }
    @XmlElement(name = "note")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
