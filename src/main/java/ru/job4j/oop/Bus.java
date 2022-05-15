package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам");
    }

    @Override
    public void printInfo() {
        System.out.println("Самый первый в мире автобус изготовил в 1801 году Ричард Тревитик");
    }
}
