package org.example.models;

import java.util.ArrayList;

public class Pago {
    private ArrayList<Producto> productos;
    private int cantidadProductos;
    private double montoTotal;
    private String metodoPago;
    private boolean pagoConfirmado;

    // Constructor
    public Pago(ArrayList<Producto> productos, int cantidadProductos, double montoTotal, String metodoPago) {
        this.productos = productos;
        this.cantidadProductos = cantidadProductos;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.pagoConfirmado = false;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public boolean isPagoConfirmado() {
        return pagoConfirmado;
    }

    // Método para procesar el pago
    public void procesarPago() {
        // Aquí se puede añadir lógica de validación de pago (tarjeta, PayPal, etc.)
        System.out.println("Procesando pago...");
        pagoConfirmado = true;
        System.out.println("Pago procesado correctamente.");
    }

    // Método para confirmar el pago
    public boolean confirmarPago() {
        if (pagoConfirmado) {
            System.out.println("Pago confirmado.");
            return true;
        } else {
            System.out.println("Error: El pago aún no ha sido procesado.");
            return false;
        }
    }

    // Método para generar la factura después de un pago exitoso
    public Factura generarFactura() {
        if (pagoConfirmado) {
            Factura factura = new Factura(productos, cantidadProductos, montoTotal, metodoPago);
            System.out.println("Factura generada.");
            return factura;
        } else {
            System.out.println("Error: No se puede generar la factura, el pago no ha sido confirmado.");
            return null;
        }
    }
}
