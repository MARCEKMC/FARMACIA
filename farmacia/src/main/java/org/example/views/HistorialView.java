package views;

import controllers.HistorialController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Factura;

import java.util.List;

public class HistorialView {
    private HistorialController historialController;

    public HistorialView() {
        this.historialController = new HistorialController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Historial de Compras");

        // Obtener el historial de facturas
        List<Factura> facturas = historialController.obtenerHistorial();

        // Crear una ListView para mostrar las facturas
        ListView<String> listView = new ListView<>();
        for (Factura factura : facturas) {
            listView.getItems().add("Factura ID: " + factura.getId() + " - Total: $" + factura.getMontoTotal());
        }

        Button btnCerrarHistorial = new Button("Cerrar Historial");

        // Acción para cerrar la ventana
        btnCerrarHistorial.setOnAction(e -> stage.close());

        // Layout
        VBox vbox = new VBox(10, listView, btnCerrarHistorial);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
