package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student alex = new Student();
        alex.setFullName("Alexandrov Anatoliy Evgen");
        alex.setNumGroup(246);
        alex.setRecDate(new Date());
        System.out.println("Full name:\t" + alex.getFullName());
        System.out.println("Group:\t" + alex.getNumGroup());
        System.out.println("Date:\t" + alex.getRecDate());
    }
}
