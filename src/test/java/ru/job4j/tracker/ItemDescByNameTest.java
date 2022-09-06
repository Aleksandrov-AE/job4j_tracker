package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ItemDescByNameTest {

    @Test
    void compare() {
        List<Item> items = Arrays.asList(new Item("1"), new Item("33"), new Item("22"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("33"), new Item("22"), new Item("1"));
        Assert.assertEquals(items, expected);
    }
}