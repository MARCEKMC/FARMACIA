package org.example.controllers;

import org.example.models.Factura;

public class FacturaController {

    // Método para mostrar una factura en detalle
    public void mostrarFactura(Factura factura) {
        if (factura != null) {
            System.out.println("Detalle de la Factura:");
            System.out.println(factura);
        } else {
            System.out.println("Factura no disponible.");
        }
    }
}
