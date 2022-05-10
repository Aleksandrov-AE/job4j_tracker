package ru.job4j.ru.job4j.pojo;

import ru.job4j.pojo.Book;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 100);
        Book java = new Book("The Complete Guide - Herbert Shield", 1500);
        Book crimeCode = new Book("Criminal Code", 1000);
        Book tomS = new Book("Tom Sawyer", 1999);
        Book[] libBooks = new Book[] {cleanCode, java, crimeCode, tomS};
        for (Book lbook: libBooks) {
            System.out.println(lbook.getName() + "\t" + lbook.getNumOfPage() + " pages");
        }
        System.out.println("\nSwap Clean Code <-> Tom Sawyer\n");
        Book tmp = libBooks[0];
        libBooks[0] = libBooks[3];
        libBooks[3] = tmp;
        for (Book lbook: libBooks) {
            System.out.println(lbook.getName() + "\t" + lbook.getNumOfPage() + " pages");
        }
        System.out.println("\nShow book with name \"Clean Code\"\n");
        for (int i = 0; i < libBooks.length; i++) {
            if ("Clean Code".equals(libBooks[i].getName())) {
                System.out.println(libBooks[i].getName());
            }

        }
    }
}