package ru.job4j.array;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        if (name.isEmpty()
                || Character.isUpperCase(name.charAt(0))
                || Character.isDigit(name.charAt(0))
                || isSpecialSymbol(name.codePointAt(0))) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (!isSpecialSymbol(name.codePointAt(i))
                    && !isUpperLatinLetter(name.codePointAt(i))
                    && !isLowerLatinLetter(name.codePointAt(i))
                    &&  !Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialSymbol(int code) {
        if (code == 36 || code == 95) {
            return true;
        }
        return false;
    }

    public static boolean isUpperLatinLetter(int code) {
        if (code >= 65 && code <= 90) {
            return true;
        }
        return false;
    }

    public static boolean isLowerLatinLetter(int code) {
        if (code >= 97 && code <= 122) {
            return true;
        }
        return false;
    }
}