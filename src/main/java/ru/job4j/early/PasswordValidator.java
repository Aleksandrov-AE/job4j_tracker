package ru.job4j.early;

public class PasswordValidator {

     public static String validate(String password) {
        boolean containLowerLetter = false;
        boolean containUpperLetter = false;
        boolean containDigit = false;
        boolean containSpecialSymbol = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
         for (int i = 0; i < password.length(); i++) {
             if (Character.isLowerCase(password.charAt(i))) {
                 containLowerLetter = true;
             }
             if (Character.isUpperCase(password.charAt(i))) {
                 containUpperLetter = true;
             }
             if (Character.isDigit(password.charAt(i))) {
                 containDigit = true;
             }
             if (!Character.isLetterOrDigit(password.charAt(i))
                     && !Character.isDigit(password.charAt(i))) {
                 containSpecialSymbol = true;
             }
             if (containLowerLetter
                     && containUpperLetter
                     && containDigit
                     && containSpecialSymbol) {
                 break;
             }

         }
         if (!containUpperLetter) {
             throw new IllegalArgumentException("Password should contain at least one uppercase letter");
         }
        if (!containLowerLetter) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!containDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containSubstringIgnore(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
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
}
