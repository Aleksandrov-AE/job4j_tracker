package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {

    }

    public Item(int i) {
        this.id = i;
    }

    public Item(int i, String n) {
        this.id = i;
        this.name = n;
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