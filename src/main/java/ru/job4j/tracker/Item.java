package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    LocalDateTime creater = LocalDateTime.now();

    public Item() {

    }

    public Item(int i) {
        this.id = i;
    }

    public Item(int i, String n) {
        this.id = i;
        this.name = n;
    }

    public Item(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", creater=" + creater.format(FORMATTER)
                + '}';
    }

    public LocalDateTime getDateTime()  {
        return creater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}