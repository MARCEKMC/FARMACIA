package org.example.models;

import java.util.ArrayList;

public class Cliente extends Observador {
    private String apellido;
    private String direccion;
    private String dni;
    private String correo;
    private String celular;
    private ArrayList<Factura> historial;

    // Constructor
    public Cliente(int id, String nombre, String apellido, String direccion, String dni, String correo, String celular) {
        super(id, nombre);  // Llama al constructor de Observador
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.correo = correo;
        this.celular = celular;
        this.historial = new ArrayList<>();
    }

    // Getters
    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public ArrayList<Factura> getHistorial() {
        return historial;
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        System.out.println("Sesión de cliente cerrada. Hasta pronto.");
    }

    // Método para realizar el pago
    public void realizarPago(Pago pago) {
        if (pago.confirmarPago()) {
            Factura factura = pago.generarFactura();
            historial.add(factura);
            System.out.println("Pago realizado con éxito. Factura generada.");
        } else {
            System.out.println("Error en el proceso de pago.");
        }
    }

    // Método para ver el historial de compras
    public void verHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay compras realizadas aún.");
        } else {
            System.out.println("Historial de compras:");
            for (Factura factura : historial) {
                System.out.println(factura);
            }
        }
    }
}
