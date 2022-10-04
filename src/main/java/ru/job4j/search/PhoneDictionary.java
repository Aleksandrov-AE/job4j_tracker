package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = p -> key.equals(p.getName());
        Predicate<Person> surname = p -> key.equals(p.getSurname());
        Predicate<Person> phone = p -> key.equals(p.getPhone());
        Predicate<Person> adress = p -> key.equals(p.getAddress());
        Predicate<Person> combine = name.or(surname).or(phone).or(adress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}