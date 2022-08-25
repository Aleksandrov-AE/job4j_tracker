package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int i) {
        return i - x;
    }

    public static int divide(int i) {
        return i / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int i) {
        return this.multiply(i) + divide(i) + minus(i) + sum(i);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("Calculator.sum(10) = " + result);
        result = Calculator.minus(10);
        System.out.println("Calculator.minus(10) = " + result);
        result = Calculator.divide(10);
        System.out.println("Calculator.divide(10) = " + result);
        Calculator calcTest = new Calculator();
        result = calcTest.multiply(10);
        System.out.println("calcTest.multiply(10) = " + result);
        result = calcTest.sumAllOperation(10);
        System.out.println("calcTest.sumAllOperation(10) = " + result);
    }
}