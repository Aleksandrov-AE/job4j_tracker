package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void printInfo() {
        System.out.println("Первый в мире самолет Flyer I совершил свой знаменитый полет 17 декабря 1903 года");
    }
}
