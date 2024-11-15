package org.example.controllers;

import org.example.models.Factura;
import org.example.models.Historial;

public class HistorialController {
    private Historial historial;

    // Constructor
    public HistorialController() {
        this.historial = new Historial();
    }

    // Método para agregar una factura al historial
    public void agregarFactura(Factura factura) {
        historial.agregarFactura(factura);
        System.out.println("Factura añadida al historial.");
    }

    // Método para observar el historial de compras
    public void mostrarHistorial() {
        System.out.println("Mostrando el historial de compras:");
        historial.observarFacturas();
    }

    // Obtener el historial en caso de necesitar acceso desde fuera
    public Historial getHistorial() {
        return historial;
    }
}
