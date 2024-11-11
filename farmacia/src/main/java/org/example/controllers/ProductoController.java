package controllers;

import models.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> listaProductos;

    // Constructor
    public ProductoController() {
        this.listaProductos = new ArrayList<>();
        inicializarProductos();
    }

    // Método para inicializar productos de prueba
    private void inicializarProductos() {
        listaProductos.add(new Producto(1, "Paracetamol", "Analgésico y antipirético", 5.50, "Recoger en tienda"));
        listaProductos.add(new Producto(2, "Ibuprofeno", "Antiinflamatorio no esteroideo", 7.00, "Envío a domicilio"));
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(int id, String nombre, String descripcion, double precio, String metodoEntrega) {
        Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, metodoEntrega);
        listaProductos.add(nuevoProducto);
        System.out.println("Producto añadido: " + nombre);
    }

    // Método para eliminar un producto por ID
    public void eliminarProducto(int id) {
        listaProductos.removeIf(producto -> producto.getId() == id);
        System.out.println("Producto con ID " + id + " eliminado.");
    }

    // Método para listar todos los productos
    public void listarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    // Método para buscar un producto por ID
    public Producto buscarProductoPorId(int id) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        System.out.println("Producto no encontrado.");
        return null;
    }
}
