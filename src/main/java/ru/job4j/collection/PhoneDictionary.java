package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var p : this.persons) {
            if (p.getPhone().contains(key)
                    || p.getName().contains(key)
                    || p.getAddress().contains(key)
                    || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}