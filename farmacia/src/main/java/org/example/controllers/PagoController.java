package controllers;

import models.Pago;
import models.Producto;
import models.Carrito;
import models.Factura;

import java.util.List;

public class PagoController {
    private CarritoController carritoController;
    private ClienteController clienteController;

    // Constructor
    public PagoController(CarritoController carritoController, ClienteController clienteController) {
        this.carritoController = carritoController;
        this.clienteController = clienteController;
    }

    // Método para procesar el pago
    public void procesarPago(String metodoPago, int idCliente) {
        Carrito carrito = carritoController.getCarrito();
        List<Producto> productos = carrito.getProductos();
        double montoTotal = carritoController.calcularTotal();

        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío. No se puede procesar el pago.");
            return;
        }

        // Crear el objeto de pago
        Pago pago = new Pago(productos, montoTotal, metodoPago);
        if (pago.procesarPago()) {
            pago.confirmarPago();

            // Generar factura
            Factura factura = new Factura(productos, montoTotal, metodoPago);
            factura.generarFactura();

            // Agregar la factura al historial del cliente
            clienteController.agregarFacturaHistorial(factura);

            // Vaciar el carrito después del pago
            carritoController.vaciarCarrito();
        } else {
            System.out.println("Error al procesar el pago.");
        }
    }
}
