package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmailValidatorTest {
    private final EmailValidator validator = new EmailValidator();

    @Test
    void cp01_correoNuloOVacio() {
        assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(null));
        assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(""));
    }

    @Test
    void cp02_sinArroba() {
        assertFalse(validator.isValidEmail("usuariogmail.com"));
    }

    @Test
    void cp03_dominioIncompleto() {
        assertFalse(validator.isValidEmail("usuario@com"));
    }

    @Test
    void cp04_correoValido() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    void cp05_sinNombreUsuario() {
        assertFalse(validator.isValidEmail("@tienda.com"));
    }

    @Test
    void cp06_excedeLongitudMaxima() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<250; i++) sb.append("a"); // 250 letras 'a'
        sb.append("@test.com"); // Total > 254

        assertFalse(validator.isValidEmail(sb.toString()));
    }


    @Test
    void cp07_doblePuntoConsecutivo() {
        assertFalse(validator.isValidEmail("user..name@tienda.com"));
    }

    @Test
    void cp08_empiezaConPunto() {
        assertFalse(validator.isValidEmail(".user@tienda.com"));
    }

    @Test
    void cp09_noPasaLongitudMinima() {
        assertFalse(validator.isValidEmail("a@b.c"));
    }
}

