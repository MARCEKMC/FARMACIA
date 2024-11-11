package controllers;

import models.Factura;
import models.Producto;
import java.util.List;

public class FacturaController {

    // Método para generar una factura
    public Factura generarFactura(List<Producto> productos, double montoTotal, String metodoPago) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No se puede generar una factura sin productos.");
            return null;
        }

        // Crear la factura
        Factura factura = new Factura(productos, montoTotal, metodoPago);
        factura.generarFactura();
        System.out.println("Factura generada exitosamente.");
        return factura;
    }

    // Método para mostrar los detalles de una factura
    public void mostrarFactura(Factura factura) {
        if (factura != null) {
            System.out.println("Detalles de la Factura:");
            System.out.println(factura);
        } else {
            System.out.println("Factura no encontrada.");
        }
    }
}
