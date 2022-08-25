package ru.job4j.pojo;

public class Book {
    private String name;
    private  int numOfPage;

    public Book(String name, int page) {
        this.name = name;
        this.numOfPage = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }
}
