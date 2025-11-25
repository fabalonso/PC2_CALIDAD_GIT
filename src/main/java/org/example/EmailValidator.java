package org.example;
import java.util.regex.Pattern;

public class EmailValidator {
    // Regex estándar para cumplir con los requisitos del examen
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public boolean isValidEmail(String email) {
        // 1. Validar Nulo o Vacío (Escenario 1)
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // 2. Validaciones manuales específicas (Reglas de negocio)
        if (!email.contains("@")) return false;       // Debe tener arroba
        if (email.startsWith(".")) return false;      // No empezar con punto
        if (email.contains("..")) return false;       // No dos puntos seguidos

        // 3. Validar Longitud (Mínimo 6, Máximo 254 RFC 5321)
        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        // 4. Validar formato completo (Regex)
        return EMAIL_PATTERN.matcher(email).matches();
    }
}


