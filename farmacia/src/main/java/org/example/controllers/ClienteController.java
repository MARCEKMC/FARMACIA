package controllers;

import models.Cliente;
import models.Factura;
import models.Historial;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> listaClientes;
    private Historial historial;

    // Constructor
    public ClienteController() {
        this.listaClientes = new ArrayList<>();
        this.historial = new Historial();
        inicializarClientes();
    }

    // Método para inicializar clientes de prueba
    private void inicializarClientes() {
        listaClientes.add(new Cliente(1, "Juan", "Ramírez", "Av. Siempre Viva 742", "12345678", "juan@mail.com", "987654321"));
        listaClientes.add(new Cliente(2, "Maria", "González", "Calle Luna 123", "87654321", "maria@mail.com", "123456789"));
    }

    // Método para agregar un nuevo cliente
    public void agregarCliente(int id, String nombre, String apellido, String direccion, String dni, String correo, String celular) {
        Cliente nuevoCliente = new Cliente(id, nombre, apellido, direccion, dni, correo, celular);
        listaClientes.add(nuevoCliente);
        System.out.println("Cliente añadido: " + nombre + " " + apellido);
    }

    // Método para eliminar un cliente por ID
    public void eliminarCliente(int id) {
        listaClientes.removeIf(cliente -> cliente.getId() == id);
        System.out.println("Cliente con ID " + id + " eliminado.");
    }

    // Método para listar todos los clientes
    public void listarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    // Método para obtener el historial de compras de un cliente
    public void verHistorial() {
        historial.observarFacturas();
    }

    // Método para agregar una factura al historial
    public void agregarFacturaHistorial(Factura factura) {
        historial.agregarFactura(factura);
    }

    // Método para buscar un cliente por ID
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }
}
