package org.example.models;

import java.util.ArrayList;

public class Factura {
    private ArrayList<Producto> productos;
    private int cantidadProductos;
    private double montoTotal;
    private String metodoPago;

    // Constructor
    public Factura(ArrayList<Producto> productos, int cantidadProductos, double montoTotal, String metodoPago) {
        this.productos = productos;
        this.cantidadProductos = cantidadProductos;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
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

    // Método para mostrar la información de la factura
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura: \n");
        for (Producto producto : productos) {
            sb.append(producto.getNombre()).append(" - $").append(producto.getPrecio()).append("\n");
        }
        sb.append("Cantidad de productos: ").append(cantidadProductos).append("\n");
        sb.append("Monto total: $").append(montoTotal).append("\n");
        sb.append("Método de pago: ").append(metodoPago).append("\n");
        return sb.toString();
    }
}
