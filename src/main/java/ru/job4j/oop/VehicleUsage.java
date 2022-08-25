package ru.job4j.oop;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = new Vehicle[]{bus, train, airplane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.printInfo();
        }
    }

}
