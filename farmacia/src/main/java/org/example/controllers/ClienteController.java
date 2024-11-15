package org.example.controllers;

import org.example.models.Cliente;
import org.example.models.Inventario;
import org.example.models.Producto;

import java.util.Scanner;

public class ClienteController {
    private Cliente cliente;
    private Inventario inventario;

    public ClienteController(Cliente cliente, Inventario inventario) {
        this.cliente = cliente;
        this.inventario = inventario;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Realizar pago");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    verProductos();
                    break;
                case 2:
                    agregarAlCarrito(scanner);
                    break;
                case 3:
                    verCarrito();
                    break;
                case 4:
                    realizarPago();
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private void verProductos() {
        inventario.verStock();
    }

    private void agregarAlCarrito(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a agregar al carrito: ");
        String nombre = scanner.nextLine();
        Producto producto = null;

        for (Producto p : inventario.getProductos()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                producto = p;
                break;
            }
        }

        if (producto != null) {
            cliente.getCarrito().agregarProducto(producto);
            System.out.println("Producto agregado al carrito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void verCarrito() {
        cliente.getCarrito().mostrarProductos();
    }

    private void realizarPago() {
        // Lógica de pago
        System.out.println("Pago realizado con éxito.");
    }
}
