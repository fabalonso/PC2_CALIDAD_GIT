package org.example;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {
        // 1. Validar Nombre Nulo
        if (item == null) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo");
        }
        // 2. Validar Nombre Vacío
        if (item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // 3. Validar Longitud de Nombre (2-50)
        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres");
        }

        // 4. Validar Cantidad (1-1000)
        if (quantity < 1) {
            throw new IllegalArgumentException("La cantidad debe ser al menos 1");
        }
        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad máxima es 1000");
        }

        // 5. Lógica: Sumar si existe, crear si no
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + quantity);
        } else {
            inventory.put(item, quantity);
        }
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}

