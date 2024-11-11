package models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar producto al inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto añadido al inventario: " + producto.getNombre());
    }

    // Método para eliminar producto del inventario
    public void eliminarProducto(int idProducto) {
        productos.removeIf(producto -> producto.getId() == idProducto);
        System.out.println("Producto con ID " + idProducto + " eliminado del inventario.");
    }

    // Método para ver el stock del inventario
    public void verStock() {
        System.out.println("Inventario actual:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    // Método para obtener un producto por ID
    public Producto buscarProductoPorId(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == idProducto) {
                return producto;
            }
        }
        System.out.println("Producto no encontrado.");
        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "totalProductos=" + productos.size() +
                '}';
    }
}
