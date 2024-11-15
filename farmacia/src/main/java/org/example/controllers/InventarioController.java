package org.example.controllers;

import org.example.models.Inventario;
import org.example.models.Producto;

public class InventarioController {
    private Inventario inventario;

    // Constructor
    public InventarioController() {
        this.inventario = new Inventario();
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(Producto producto) {
        inventario.eliminarProducto(producto);
    }

    // Método para mostrar el stock de productos en el inventario
    public void mostrarInventario() {
        System.out.println("Mostrando el inventario de productos:");
        inventario.verStock();
    }

    // Obtener acceso al inventario (en caso de necesitarlo externamente)
    public Inventario getInventario() {
        return inventario;
    }
}
