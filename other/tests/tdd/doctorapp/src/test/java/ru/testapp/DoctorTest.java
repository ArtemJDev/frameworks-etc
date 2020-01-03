package ru.testapp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DoctorTest {

    @Test
    public void shouldBuildReg() {
        Doctor doctor = new Doctor();
        Register register = doctor
            .register(new Patient())
            .register(new Pinicilin())
            .register(new Purgative())
            .build();

        Pinicilin pinicilin = register.get(Pinicilin.class);
        Patient patient = register.get(Patient.class);
        Assert.assertEquals(pinicilin, patient.getPinicilin());
    }
}