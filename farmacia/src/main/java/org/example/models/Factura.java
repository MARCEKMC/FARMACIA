package models;

import java.util.List;

public class Factura {
    private List<Producto> productos;
    private double montoTotal;
    private String metodoPago;
    private static int contadorFacturas = 0;
    private int numeroFactura;

    // Constructor
    public Factura(List<Producto> productos, double montoTotal, String metodoPago) {
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.numeroFactura = ++contadorFacturas;
    }

    // Métodos getters y setters
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    // Método para generar la factura
    public void generarFactura() {
        System.out.println("Factura N°: " + numeroFactura);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + " - $" + producto.getPrecio());
        }
        System.out.println("Monto total: $" + montoTotal);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numeroFactura=" + numeroFactura +
                ", montoTotal=" + montoTotal +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
