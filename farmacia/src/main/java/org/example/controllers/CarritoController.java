package controllers;

import models.Carrito;
import models.Producto;

public class CarritoController {
    private Carrito carrito;

    // Constructor
    public CarritoController() {
        this.carrito = new Carrito();
    }

    // Método para agregar un producto al carrito
    public void agregarProductoAlCarrito(Producto producto, int cantidad) {
        if (producto != null && cantidad > 0) {
            carrito.agregarProducto(producto, cantidad);
            System.out.println("Producto añadido al carrito: " + producto.getNombre() + " (Cantidad: " + cantidad + ")");
        } else {
            System.out.println("No se pudo agregar el producto al carrito.");
        }
    }

    // Método para eliminar un producto del carrito
    public void eliminarProductoDelCarrito(int idProducto) {
        carrito.eliminarProducto(idProducto);
        System.out.println("Producto con ID " + idProducto + " eliminado del carrito.");
    }

    // Método para ver los productos en el carrito
    public void verCarrito() {
        carrito.observarProductoCarrito();
    }

    // Método para calcular el total del carrito
    public double calcularTotal() {
        double total = carrito.calcularMontoTotal();
        System.out.println("El monto total del carrito es: $" + total);
        return total;
    }

    // Método para vaciar el carrito
    public void vaciarCarrito() {
        carrito.vaciarCarrito();
        System.out.println("Carrito vaciado.");
    }

    // Obtener el carrito actual
    public Carrito getCarrito() {
        return carrito;
    }
}
