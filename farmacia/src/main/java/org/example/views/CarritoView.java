package views;

import controllers.CarritoController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Carrito;
import models.Producto;

import java.util.List;

public class CarritoView {
    private CarritoController carritoController;

    public CarritoView() {
        this.carritoController = new CarritoController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Carrito de Compras");

        // Obtener el carrito actual
        Carrito carrito = carritoController.obtenerCarrito();

        // Mostrar los productos en el carrito
        List<Producto> productos = carrito.getProductos();
        VBox productosBox = new VBox(10);
        for (Producto producto : productos) {
            productosBox.getChildren().add(new Label(producto.getNombre() + " - $" + producto.getPrecio()));
        }

        // Mostrar el total
        Label lblTotal = new Label("Monto Total: $" + carrito.getMontoTotal());

        // Botón para realizar el pago
        Button btnRealizarPago = new Button("Realizar Pago");
        btnRealizarPago.setOnAction(e -> {
            carritoController.realizarPago();
            System.out.println("Pago realizado.");
            stage.close(); // Cerrar la ventana después de realizar el pago
        });

        // Layout
        VBox vbox = new VBox(10, productosBox, lblTotal, btnRealizarPago);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
