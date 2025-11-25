package org.example;

public class TextProcessor {

    public static String reverseAndCapitalize(String input) {
        // 1. Validar Nulo
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // 2. Validar Vacío o Solo Espacios
        if (input.trim().isEmpty()) {
            // El examen pide validar que no sea vacío ni solo espacios
            // Usamos trim().isEmpty() para cubrir ambos casos de una vez
            throw new IllegalArgumentException("El texto no puede estar vacío ni contener solo espacios");
        }

        // 3. Validar Longitud (Máximo 1000)
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // 4. Transformación: Trim -> Invertir -> Mayúsculas
        String trimmed = input.trim();
        StringBuilder reversed = new StringBuilder(trimmed).reverse();
        return reversed.toString().toUpperCase();
    }
}
