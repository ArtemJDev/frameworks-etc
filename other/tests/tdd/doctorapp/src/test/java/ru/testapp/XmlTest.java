package ru.testapp;

import org.junit.Test;

/**
 * We can create a doctor or registry class , but we also want to download and upload other formats.
 * so - create new class for xml work
 */
public class XmlTest {

    /**
     * Interface for writing
     */
    private Pencil pencil = new XmlPencil("target/hospital.xml");

    @Test
    public void canSaveConfigToXmlFile() {

        Doctor doctor = new Doctor();
        Register register = doctor
            .register(new Patient())
            .register(new Pinicilin())
            .register(new Purgative())
            .build();

        register.write(pencil);
    }
}
