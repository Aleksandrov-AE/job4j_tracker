package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals; // JUnit 5

class ItemDescByNameTest {

    @Test
    void compare() {
        List<Item> items = Arrays.asList(new Item("1"), new Item("33"), new Item("22"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("33"), new Item("22"), new Item("1"));
        assertEquals(expected, items); // порядок: expected, actual
    }
}
