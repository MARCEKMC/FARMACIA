package org.example.controllers;

import org.example.models.Producto;

import java.util.ArrayList;

public class ProductoController {
    private ArrayList<Producto> productos;

    // Constructor
    public ProductoController() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un producto a la lista
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    // Método para mostrar los productos disponibles
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio());
            }
        }
    }

    // Obtener la lista de productos
    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
