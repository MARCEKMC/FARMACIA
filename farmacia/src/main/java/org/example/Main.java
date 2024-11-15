package org.example;

import org.example.controllers.ClienteController;
import org.example.controllers.ProveedorController;
import org.example.models.Cliente;
import org.example.models.Inventario;
import org.example.models.Proveedor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un inventario
        Inventario inventario = new Inventario();

        // Crear un proveedor
        Proveedor proveedor = new Proveedor(1, "Proveedor", "Apellidos", "Dirección", "12345678", "proveedor@example.com", "Empresa", "987654321");
        ProveedorController proveedorController = new ProveedorController(proveedor, inventario);

        // Crear un cliente
        Cliente cliente = new Cliente(2, "Cliente", "Apellidos", "Dirección", "87654321", "cliente@example.com", "987654321");
        ClienteController clienteController = new ClienteController(cliente, inventario);

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Iniciar sesión como cliente");
            System.out.println("2. Iniciar sesión como proveedor");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    clienteController.mostrarMenu();
                    break;
                case 2:
                    proveedorController.mostrarMenu();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}
