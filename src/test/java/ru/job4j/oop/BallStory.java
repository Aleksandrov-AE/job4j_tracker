package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Fox cunning = new Fox();
        Hare fast = new Hare();
        Wolf evil = new Wolf();
        Ball round = new Ball();
        fast.tryEat(round);
        evil.tryEat(round);
        cunning.tryEat(round);
    }
}
