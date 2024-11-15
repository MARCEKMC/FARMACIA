package org.example.models;

public class Observador {
    private int id;
    private String nombre;
    private Carrito carrito;

    // Constructor
    public Observador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.carrito = new Carrito(); // Inicializa el carrito
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    // Métodos relacionados con el carrito
    public void verProducto(Inventario inventario) {
        // Muestra todos los productos del inventario
        System.out.println("Lista de productos disponibles en la farmacia:");
        inventario.verStock();
    }

    public void agregarAlCarrito(Producto producto) {
        // Agrega un producto al carrito
        carrito.agregarProducto(producto);
        System.out.println("Producto añadido al carrito: " + producto.getNombre());
    }

    public void mostrarCarrito() {
        // Muestra los productos en el carrito
        carrito.mostrarProductos();
    }

    // Método para cerrar sesión (en general para cualquier tipo de usuario)
    public void cerrarSesion() {
        System.out.println("Sesión cerrada. Hasta pronto, " + nombre + ".");
    }
}
