package org.example.controllers;

import org.example.models.Inventario;
import org.example.models.Producto;
import org.example.models.Proveedor;

import java.util.Scanner;

public class ProveedorController {
    private Proveedor proveedor;
    private Inventario inventario;

    public ProveedorController(Proveedor proveedor, Inventario inventario) {
        this.proveedor = proveedor;
        this.inventario = inventario;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Proveedor ---");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    inventario.verStock();
                    break;
                case 2:
                    agregarProducto(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();

        Producto nuevoProducto = new Producto(nombre, precio, descripcion);
        inventario.agregarProducto(nuevoProducto);
        System.out.println("Producto agregado al inventario.");
    }

    private void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        Producto productoAEliminar = null;

        for (Producto p : inventario.getProductos()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                productoAEliminar = p;
                break;
            }
        }

        if (productoAEliminar != null) {
            inventario.eliminarProducto(productoAEliminar);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
