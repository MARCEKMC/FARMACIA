package org.example.models;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos;
    private int cantidadProductos;
    private double montoTotal;

    // Constructor
    public Carrito() {
        this.productos = new ArrayList<>();
        this.cantidadProductos = 0;
        this.montoTotal = 0.0;
    }

    // Getters
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        cantidadProductos++;
        montoTotal += producto.getPrecio();
        System.out.println(producto.getNombre() + " ha sido añadido al carrito.");
    }

    // Método para mostrar los productos en el carrito
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
            System.out.println("Total de productos: " + cantidadProductos);
            System.out.println("Monto total: $" + montoTotal);
        }
    }

    // Método para realizar el pago
    public Pago realizarPago(String metodoPago) {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío, no se puede proceder con el pago.");
            return null;
        } else {
            return new Pago(productos, cantidadProductos, montoTotal, metodoPago);
        }
    }
}
