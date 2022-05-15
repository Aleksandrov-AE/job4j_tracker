package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The bus is moving at 40 miles per hour");
    }

    @Override
    public void passanger(int pass) {
        System.out.println("The bus can carry " + pass + "passengers");
    }

    @Override
    public float refuel(float fuel) {
        return fuel * 43.33F;
    }
}
