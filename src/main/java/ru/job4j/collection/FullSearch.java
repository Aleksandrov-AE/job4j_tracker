package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task2> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task2 tasks: list) {
            numbers.add(tasks.getNumber());
        }
        return numbers;
    }
}