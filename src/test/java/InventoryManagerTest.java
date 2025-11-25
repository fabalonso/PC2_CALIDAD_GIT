package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class InventoryManagerTest {

    private InventoryManager manager;





    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
    }

    @Test
    void cp01_agregarItemNuevo() {
        // Caso: Inventario vacío -> Agregar "Laptop", 5
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    @Test
    void cp02_cantidadNegativa() {
        // Caso: Cantidad negativa (-1)
        Exception e = assertThrows(IllegalArgumentException.class, () -> manager.addItem("Mouse", -1));
        assertEquals("La cantidad debe ser al menos 1", e.getMessage());
    }

    @Test
    void cp03_nombreItemVacio() {
        // Caso: Ítem vacío ""
        Exception e = assertThrows(IllegalArgumentException.class, () -> manager.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", e.getMessage());
    }

    @Test
    void cp04_nombreItemCorto() {
        // Caso: Nombre debajo del mínimo ("A")
        Exception e = assertThrows(IllegalArgumentException.class, () -> manager.addItem("A", 20));
        assertEquals("El nombre debe tener entre 2 y 50 caracteres", e.getMessage());
    }

    @Test
    void cp05_actualizarItemExistente() {
        // Caso: Actualizar producto existente
        manager.addItem("Laptop", 5); // Estado inicial
        manager.addItem("Laptop", 3); // Agregamos más
        assertEquals(8, manager.getStock("Laptop")); // 5 + 3 = 8
    }

    @Test
    void cp06_nombreMuyLargo() {
        // Caso: Nombre excede máximo (>50)
        String nombreLargo = "A".repeat(51);
        assertThrows(IllegalArgumentException.class, () -> manager.addItem(nombreLargo, 5));
    }

    @Test
    void cp07_cantidadExcedeMaximo() {
        // Adicional: Cantidad excede máximo (1001)
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Laptop", 1001));
    }

    @Test
    void cp08_cantidadEsCero() {
        // Adicional: Cantidad es 0
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Laptop", 0));
    }

    @Test
    void cp09_nombreItemEsNulo() {
        // Adicional: Nombre nulo
        Exception e = assertThrows(IllegalArgumentException.class, () -> manager.addItem(null, 5));
        assertEquals("El nombre del producto no puede ser nulo", e.getMessage());
    }
}
