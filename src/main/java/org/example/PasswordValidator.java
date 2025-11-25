package org.example;

public class PasswordValidator {
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/";

    public static boolean isValid(String password) {

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }


        if (password.contains(" ")) {
            return false;
        }


        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (SPECIAL_CHARS.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
