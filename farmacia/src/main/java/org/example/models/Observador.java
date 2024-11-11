package models;

import java.util.ArrayList;
import java.util.List;

public class Observador {
    private int id;
    private String nombre;
    private Carrito carrito;

    // Constructor
    public Observador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.carrito = new Carrito(); // Inicializamos un carrito vacío para el observador
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

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    // Método para ver productos (podríamos listar productos del inventario)
    public void verProducto(List<Producto> productos) {
        System.out.println("Lista de productos disponibles:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    // Método para agregar producto al carrito
    public void agregarAlCarrito(Producto producto, int cantidad) {
        carrito.agregarProducto(producto, cantidad);
        System.out.println("Producto agregado al carrito: " + producto.getNombre());
    }

    @Override
    public String toString() {
        return "Observador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
