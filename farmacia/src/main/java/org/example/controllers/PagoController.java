package org.example.controllers;

import org.example.models.Pago;

public class PagoController {

    // Método para procesar el pago
    public void procesarPago(Pago pago) {
        if (pago != null) {
            pago.procesarPago();
            System.out.println("Pago procesado con éxito.");
        } else {
            System.out.println("Error: No se pudo procesar el pago.");
        }
    }

    // Método para confirmar el pago
    public void confirmarPago(Pago pago) {
        if (pago.confirmarPago()) {
            System.out.println("El pago ha sido confirmado.");
        } else {
            System.out.println("Error: No se pudo confirmar el pago.");
        }
    }
}
