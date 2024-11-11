package views;

import controllers.ClienteController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Cliente;
import models.Factura;

public class ClienteView {
    private ClienteController clienteController;

    public ClienteView() {
        this.clienteController = new ClienteController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Gestión de Clientes");

        // Crear el cliente de ejemplo para mostrar los datos
        Cliente cliente = clienteController.obtenerClientePorId(1); // Obtener el cliente por ID

        // Crear etiquetas con la información del cliente
        Label lblNombre = new Label("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
        Label lblDireccion = new Label("Dirección: " + cliente.getDireccion());
        Label lblCorreo = new Label("Correo: " + cliente.getCorreo());
        Label lblCelular = new Label("Celular: " + cliente.getCelular());

        // Botón para ver historial de compras
        Button btnVerHistorial = new Button("Ver Historial de Compras");
        btnVerHistorial.setOnAction(e -> {
            // Mostrar historial de compras
            clienteController.verHistorial(cliente);
        });

        // Botón para realizar un pago
        Button btnRealizarPago = new Button("Realizar Pago");
        btnRealizarPago.setOnAction(e -> {
            // Método para procesar el pago
            clienteController.realizarPago(cliente);
        });

        // Layout
        VBox vbox = new VBox(10, lblNombre, lblDireccion, lblCorreo, lblCelular, btnVerHistorial, btnRealizarPago);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 350);
        stage.setScene(scene);
        stage.show();
    }
}
