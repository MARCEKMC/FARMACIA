package org.example.controllers;

import org.example.models.Carrito;
import org.example.models.Producto;
import org.example.models.Pago;

public class CarritoController {
    private Carrito carrito;

    // Constructor
    public CarritoController() {
        this.carrito = new Carrito();
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        carrito.agregarProducto(producto);
    }

    // Método para mostrar los productos en el carrito
    public void mostrarCarrito() {
        carrito.mostrarProductos();
    }

    // Método para realizar el pago del carrito
    public Pago realizarPago(String metodoPago) {
        Pago pago = carrito.realizarPago(metodoPago);
        if (pago != null) {
            System.out.println("Pago generado con éxito.");
        } else {
            System.out.println("No se pudo generar el pago.");
        }
        return pago;
    }

    // Obtener acceso al carrito (en caso de necesitarlo externamente)
    public Carrito getCarrito() {
        return carrito;
    }
}
