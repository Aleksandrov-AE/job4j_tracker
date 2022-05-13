package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.io.PrintStream;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item cup = new Item();
        LocalDateTime currentDateTime = cup.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);
        Item tops = new Item(22, "Tops");
        System.out.println(tops);
    }
}
