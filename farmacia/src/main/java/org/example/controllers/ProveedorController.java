package controllers;

import models.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {
    private List<Proveedor> listaProveedores;

    // Constructor
    public ProveedorController() {
        this.listaProveedores = new ArrayList<>();
        inicializarProveedores();
    }

    // Método para inicializar proveedores de prueba
    private void inicializarProveedores() {
        listaProveedores.add(new Proveedor(1, "Carlos", "Pérez", "Av. Principal 123", "12345678", "carlos@empresa.com", "Farmacéutica XYZ", "987654321"));
        listaProveedores.add(new Proveedor(2, "Ana", "López", "Calle Secundaria 456", "87654321", "ana@empresa.com", "Distribuidora ABC", "123456789"));
    }

    // Método para agregar un proveedor
    public void agregarProveedor(int id, String nombre, String apellido, String direccion, String dni, String correo, String empresa, String celular) {
        Proveedor nuevoProveedor = new Proveedor(id, nombre, apellido, direccion, dni, correo, empresa, celular);
        listaProveedores.add(nuevoProveedor);
        System.out.println("Proveedor añadido: " + nombre + " " + apellido);
    }

    // Método para eliminar un proveedor por ID
    public void eliminarProveedor(int id) {
        listaProveedores.removeIf(proveedor -> proveedor.getId() == id);
        System.out.println("Proveedor con ID " + id + " eliminado.");
    }

    // Método para listar todos los proveedores
    public void listarProveedores() {
        System.out.println("Lista de proveedores:");
        for (Proveedor proveedor : listaProveedores) {
            System.out.println(proveedor);
        }
    }

    // Método para buscar un proveedor por ID
    public Proveedor buscarProveedorPorId(int id) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getId() == id) {
                return proveedor;
            }
        }
        System.out.println("Proveedor no encontrado.");
        return null;
    }
}
