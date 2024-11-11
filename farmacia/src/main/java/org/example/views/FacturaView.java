package views;

import controllers.FacturaController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Factura;

public class FacturaView {
    private FacturaController facturaController;

    public FacturaView() {
        this.facturaController = new FacturaController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Generar Factura");

        // Crear una factura de ejemplo
        Factura factura = facturaController.generarFactura();

        // Mostrar detalles de la factura
        Label lblFactura = new Label("Factura Generada: ");
        Label lblProductos = new Label("Productos: " + factura.getProductos());
        Label lblMontoTotal = new Label("Monto Total: $" + factura.getMontoTotal());
        Label lblMetodoPago = new Label("Método de Pago: " + factura.getMetodoPago());

        Button btnImprimirFactura = new Button("Imprimir Factura");

        // Acción de impresión (simple ejemplo de muestra)
        btnImprimirFactura.setOnAction(e -> {
            System.out.println("Factura impresa.");
            stage.close(); // Cerrar la ventana después de imprimir
        });

        // Layout
        VBox vbox = new VBox(10, lblFactura, lblProductos, lblMontoTotal, lblMetodoPago, btnImprimirFactura);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
