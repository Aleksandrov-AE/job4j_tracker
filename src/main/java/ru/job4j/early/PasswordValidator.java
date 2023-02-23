package ru.job4j.early;

public class PasswordValidator {
    private static boolean containUpperLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containLowerLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containSpecialSymbol(String s) {
        String specialCharacters = "!@#$%&*()'+,-./:;<=>?@[\\]^_`{|}~";
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))
                    && specialCharacters.contains(String.valueOf(s.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

     private static boolean containSubstringIgnore(String s) {
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
         for (String substring: substrings) {
             if (s.toLowerCase().contains(substring)) {
                 return true;
             }
         }
         return false;
     }

     public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containUpperLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!containLowerLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!containDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containSubstringIgnore(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
