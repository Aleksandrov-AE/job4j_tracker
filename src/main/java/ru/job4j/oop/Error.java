package ru.job4j.oop;

public class Error {
    private  boolean active;
    private  int status;
    private String message;

    public Error() {

    }

    public Error(boolean act, int stat, String mess) {
        this.active = act;
        this.status = stat;
        this.message = mess;
    }

    public void printInfo() {
        System.out.println("Error active:" + this.active);
        System.out.println("      status:" + this.status);
        System.out.println("      message:" + this.message);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        Error errorConst1 = new Error(false, 11, "line 22");
        Error errorConst2 = new Error(false, 121, "line 2");
        errorDefault.printInfo();
        errorConst1.printInfo();
        errorConst2.printInfo();
    }
}
