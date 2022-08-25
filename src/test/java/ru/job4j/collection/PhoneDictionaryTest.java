package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "536872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenFindByNameNull() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "538872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Kosta");
        assertEquals(persons.size(), 0);
    }
}