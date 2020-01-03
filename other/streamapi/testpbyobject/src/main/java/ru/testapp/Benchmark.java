package ru.testapp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Benchmark {

        public static final int ARRAY_LENGTH = 1_000;

         Person[] array;

        public void initState() {
            Random random = new Random();
            this.array = new Person[ARRAY_LENGTH];
            for (int i = 0; i < this.array.length; i++) {
                Person person = new Person();
                person.setName("N" + random.nextInt());
                person.setAge(random.nextInt(200));
                person.setChildren(random.nextInt(100));
                this.array[i] = person;
            }
        }

    public List<Person> streamApi() {
        List<Person> result = Arrays.stream(array)
            .filter(person -> person.getAge() > 18)
            .filter(person -> person.getChildren() > 50)
            .collect(Collectors.toList());
        return result;
    }

    public List<Person> streamApiOneFilter() {
            List<Person> result = Arrays.stream(array)
                .filter(person -> person.getAge() > 18 && person.getChildren() > 50)
                .collect(Collectors.toList());
        return result;

    }




}
