package org.example.models;

public class Proveedor {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String correo;
    private String empresa;
    private String celular;

    // Constructor
    public Proveedor(int id, String nombre, String apellido, String direccion, String dni, String correo, String empresa, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.correo = correo;
        this.empresa = empresa;
        this.celular = celular;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

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

    public String getEmpresa() {
        return empresa;
    }

    public String getCelular() {
        return celular;
    }

    // Método para cerrar sesión
    public void cerrarSesion() {
        System.out.println("Sesión cerrada. Gracias por utilizar nuestro sistema.");
    }

    // Método para ver el inventario
    public void verInventario(Inventario inventario) {
        System.out.println("Inventario de productos disponibles:");
        inventario.verStock();  // Asegúrate de que el inventario tenga este método
    }

    // Método para agregar productos al inventario
    public void agregarProducto(Inventario inventario, Producto producto) {
        inventario.agregarProducto(producto);  // Asegúrate de que el inventario tenga este método
        System.out.println("Producto agregado al inventario: " + producto.getNombre());
    }

    // Método para eliminar productos del inventario
    public void eliminarProducto(Inventario inventario, Producto producto) {
        inventario.eliminarProducto(producto);  // Asegúrate de que el inventario tenga este método
        System.out.println("Producto eliminado del inventario: " + producto.getNombre());
    }
}
