package views;

import controllers.PagoController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Pago;

public class PagoView {
    private PagoController pagoController;

    public PagoView() {
        this.pagoController = new PagoController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Procesar Pago");

        // Etiquetas y elementos para la vista de pago
        Label lblMontoTotal = new Label("Monto Total: $100.00"); // Ejemplo de monto total
        ComboBox<String> cbMetodoPago = new ComboBox<>();
        cbMetodoPago.getItems().addAll("Tarjeta de Crédito", "Efectivo", "Transferencia");
        cbMetodoPago.setPromptText("Seleccionar Método de Pago");

        Button btnConfirmarPago = new Button("Confirmar Pago");

        // Acción para procesar el pago
        btnConfirmarPago.setOnAction(e -> {
            String metodoPago = cbMetodoPago.getValue();
            if (metodoPago != null) {
                Pago pago = new Pago(100.00, metodoPago); // Ejemplo de monto de pago
                pagoController.procesarPago(pago);
                System.out.println("Pago realizado con éxito mediante " + metodoPago);
                stage.close();
            } else {
                System.out.println("Debe seleccionar un método de pago.");
            }
        });

        // Layout
        VBox vbox = new VBox(10, lblMontoTotal, cbMetodoPago, btnConfirmarPago);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
