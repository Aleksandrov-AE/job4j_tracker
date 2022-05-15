package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам");
    }

    @Override
    public void printInfo() {
        System.out.println("19 сентября 1825 года по первой общественной железной дороге между Дарлингтоном и Стоктоном прошел первый поезд");
    }
}
