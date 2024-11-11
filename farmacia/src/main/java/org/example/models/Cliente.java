package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String correo;
    private String celular;
    private List<Factura> historialCompras;

    // Constructor
    public Cliente(int id, String nombre, String apellido, String direccion, String dni, String correo, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.correo = correo;
        this.celular = celular;
        this.historialCompras = new ArrayList<>();
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        System.out.println("Sesión cerrada para el cliente: " + nombre);
    }

    // Método para realizar un pago
    public void realizarPago(Carrito carrito, String metodoPago) {
        Pago pago = new Pago(carrito.getProductos(), carrito.getTotal(), metodoPago);
        if (pago.procesarPago()) {
            Factura factura = new Factura(carrito.getProductos(), carrito.getTotal(), metodoPago);
            historialCompras.add(factura);
            System.out.println("Pago realizado exitosamente. Factura generada.");
        } else {
            System.out.println("El pago no pudo ser procesado.");
        }
    }

    // Método para ver el historial de compras
    public void verHistorial() {
        System.out.println("Historial de compras del cliente: " + nombre);
        for (Factura factura : historialCompras) {
            System.out.println(factura);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
