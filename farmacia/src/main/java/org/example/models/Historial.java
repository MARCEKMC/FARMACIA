package models;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Factura> listaFacturas;

    // Constructor
    public Historial() {
        this.listaFacturas = new ArrayList<>();
    }

    // Método para agregar una factura al historial
    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
        System.out.println("Factura N°" + factura.getNumeroFactura() + " añadida al historial.");
    }

    // Método para observar todas las facturas
    public void observarFacturas() {
        if (listaFacturas.isEmpty()) {
            System.out.println("No hay facturas en el historial.");
        } else {
            System.out.println("Historial de facturas:");
            for (Factura factura : listaFacturas) {
                factura.generarFactura();
            }
        }
    }

    // Obtener lista de facturas
    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "totalFacturas=" + listaFacturas.size() +
                '}';
    }
}
