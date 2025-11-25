package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TextProcessorTest {
    @Test
    void cp01_textoValido() {

        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("Hola"));
    }

    @Test
    void cp02_textoNulo() {

        Exception e = assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(null));

        assertNotNull(e);
    }

    @Test
    void cp03_excedeLongitud() {

        String textoLargo = "a".repeat(1001);
        Exception e = assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(textoLargo));
        assertEquals("El texto excede el límite de 1000 caracteres", e.getMessage());
    }

    @Test
    void cp04_textoConEspacios() {

        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize(""));
        assertThrows(IllegalArgumentException.class, () -> TextProcessor.reverseAndCapitalize("   "));
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola"));
    }

    @Test
    void cp05_caracteresNumericos() {

        assertEquals("321", TextProcessor.reverseAndCapitalize("123"));
    }

    @Test
    void cp06_mezclaMayusMinus() {

        assertEquals("CBA", TextProcessor.reverseAndCapitalize("abC"));
    }


    @Test
    void testConstructorPrivado() {
        assertNotNull(new TextProcessor());
    }


}
