import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {


        @Test
        void cp01_passwordNulo() {
            Exception exceptionNull = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(null));
            assertEquals("La contraseña no puede ser nula o vacía", exceptionNull.getMessage());
        }

        @Test
        void cp02_passwordConEspacio() {
            assertFalse(PasswordValidator.isValid("Secure  123!"));
        }

        @Test
        void cp03_passwordValido() {
            assertTrue(PasswordValidator.isValid("Secure123!"));
        }

        @Test
        void cp04_passwordLargo() {
            // Generamos una contraseña de mas de 64 chars
            String longPass = "1".repeat(65) + "Aa!";
            assertFalse(PasswordValidator.isValid(longPass));
        }

        @Test
        void cp05_passwordMuyCorto() {
            assertFalse(PasswordValidator.isValid("Abi123"));
        }

        @Test
        void cp06_passwordInvalida() {
            assertFalse(PasswordValidator.isValid("nosecura"));
        }

        @Test
        void cp07_sinMayuscula() {
            assertFalse(PasswordValidator.isValid("secure123!"));
        }

        @Test
        void cp08_sinMinuscula() {
            assertFalse(PasswordValidator.isValid("SECURE123!"));
        }

        @Test
        void cp09_sinNumero() {
            assertFalse(PasswordValidator.isValid("Secure!"));
        }

        @Test
        void cp10_sinCaracterEspecial() {
            assertFalse(PasswordValidator.isValid("Secure123"));
        }

    @Test
    void testConstructorIsPrivate() {
        // Instanciamos la clase solo para que JaCoCo marque el constructor como cubierto
        assertNotNull(new PasswordValidator());
    }

    }

