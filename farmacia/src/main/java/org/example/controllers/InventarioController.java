package controllers;

import models.Inventario;
import models.Producto;

import java.util.List;

public class InventarioController {
    private Inventario inventario;

    // Constructor
    public InventarioController() {
        this.inventario = new Inventario();
    }

    // Método para agregar un producto al inventario
    public void agregarProductoAlInventario(int id, String nombre, String descripcion, double precio, String metodoEntrega) {
        Producto producto = new Producto(id, nombre, descripcion, precio, metodoEntrega);
        inventario.agregarProducto(producto);
        System.out.println("Producto añadido al inventario: " + nombre);
    }

    // Método para eliminar un producto del inventario por ID
    public void eliminarProductoDelInventario(int idProducto) {
        boolean eliminado = inventario.eliminarProducto(idProducto);
        if (eliminado) {
            System.out.println("Producto con ID " + idProducto + " eliminado del inventario.");
        } else {
            System.out.println("No se encontró el producto con ID " + idProducto + " en el inventario.");
        }
    }

    // Método para ver todos los productos del inventario
    public void verInventario() {
        List<Producto> productos = inventario.verStock();
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    // Método para buscar un producto por ID en el inventario
    public Producto buscarProductoEnInventario(int idProducto) {
        Producto producto = inventario.buscarProductoPorId(idProducto);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
        return producto;
    }
}
