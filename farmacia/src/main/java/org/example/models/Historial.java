package org.example.models;

import java.util.ArrayList;

public class Historial {
    private ArrayList<Factura> listaFacturas;

    // Constructor
    public Historial() {
        this.listaFacturas = new ArrayList<>();
    }

    // Método para añadir una factura al historial
    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
        System.out.println("Factura añadida al historial.");
    }

    // Método para ver el historial de facturas
    public void observarFacturas() {
        if (listaFacturas.isEmpty()) {
            System.out.println("El historial de compras está vacío.");
        } else {
            System.out.println("Historial de facturas:");
            for (Factura factura : listaFacturas) {
                System.out.println(factura);
            }
        }
    }

    // Getters
    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
}
