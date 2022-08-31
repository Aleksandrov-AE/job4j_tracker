package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        FullSearch fullSearch = new FullSearch();
        List<Task2> tasks = Arrays.asList(
                new Task2("1", "First desc"),
                new Task2("2", "Second desc"),
                new Task2("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }
}