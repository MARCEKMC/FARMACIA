package models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private List<Integer> cantidades;
    private double total;

    // Constructor
    public Carrito() {
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
        total += producto.getPrecio() * cantidad;
        System.out.println("Producto añadido al carrito: " + producto.getNombre() + " x" + cantidad);
    }

    // Método para obtener el total del carrito
    public double getTotal() {
        return total;
    }

    // Método para listar productos en el carrito
    public void observarProductoCarrito() {
        System.out.println("Productos en el carrito:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println(producto.getNombre() + " x" + cantidad + " - Precio unitario: " + producto.getPrecio());
        }
        System.out.println("Total: " + total);
    }

    // Método para vaciar el carrito
    public void vaciarCarrito() {
        productos.clear();
        cantidades.clear();
        total = 0.0;
        System.out.println("El carrito ha sido vaciado.");
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "total=" + total +
                ", productos=" + productos.size() +
                '}';
    }
}
