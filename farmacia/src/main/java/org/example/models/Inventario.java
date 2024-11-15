package org.example.models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Métodos para agregar, eliminar y ver productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public void verStock() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
