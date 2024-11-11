package controllers;

import models.Factura;
import models.Historial;

public class HistorialController {
    private Historial historial;

    // Constructor
    public HistorialController() {
        this.historial = new Historial();
    }

    // Método para agregar una factura al historial
    public void agregarFactura(Factura factura) {
        if (factura != null) {
            historial.agregarFactura(factura);
            System.out.println("Factura añadida al historial.");
        } else {
            System.out.println("No se puede agregar una factura nula.");
        }
    }

    // Método para mostrar el historial completo
    public void verHistorial() {
        System.out.println("Historial de compras:");
        historial.observarFacturas();
    }

    // Método para obtener una factura específica del historial
    public Factura obtenerFacturaPorId(int idFactura) {
        Factura factura = historial.obtenerFacturaPorId(idFactura);
        if (factura != null) {
            System.out.println("Factura encontrada: " + factura);
        } else {
            System.out.println("No se encontró una factura con ID " + idFactura);
        }
        return factura;
    }
}
