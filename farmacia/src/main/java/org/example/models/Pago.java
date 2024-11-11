package models;

import java.util.List;

public class Pago {
    private List<Producto> productos;
    private double montoTotal;
    private String metodoPago;

    // Constructor
    public Pago(List<Producto> productos, double montoTotal, String metodoPago) {
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
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

    // Método para procesar el pago
    public boolean procesarPago() {
        if (montoTotal <= 0) {
            System.out.println("El monto total es inválido para procesar el pago.");
            return false;
        }

        // Aquí se podrían añadir métodos para validar pagos con diferentes métodos (tarjeta, efectivo, etc.)
        System.out.println("Procesando pago de " + montoTotal + " mediante " + metodoPago);
        return true; // Simulamos que el pago es siempre exitoso
    }

    // Método para confirmar el pago
    public void confirmarPago() {
        System.out.println("Pago confirmado. Monto pagado: " + montoTotal);
    }

    @Override
    public String toString() {
        return "Pago{" +
                "montoTotal=" + montoTotal +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
