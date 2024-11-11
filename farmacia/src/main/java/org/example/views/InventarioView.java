package views;

import controllers.InventarioController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Producto;

public class InventarioView {
    private InventarioController inventarioController;

    public InventarioView() {
        this.inventarioController = new InventarioController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Gestión de Inventario");

        // Campos para agregar un producto
        TextField txtNombreProducto = new TextField();
        txtNombreProducto.setPromptText("Nombre del Producto");
        TextField txtDescripcion = new TextField();
        txtDescripcion.setPromptText("Descripción del Producto");
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        TextField txtCantidad = new TextField();
        txtCantidad.setPromptText("Cantidad en Stock");

        Button btnAgregarProducto = new Button("Agregar Producto");
        Button btnEliminarProducto = new Button("Eliminar Producto");

        // Acción para agregar un producto al inventario
        btnAgregarProducto.setOnAction(e -> {
            String nombre = txtNombreProducto.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            Producto producto = new Producto(0, nombre, descripcion, precio, cantidad);
            inventarioController.agregarProducto(producto);
            System.out.println("Producto agregado: " + nombre);
            stage.close();
        });

        // Acción para eliminar un producto del inventario
        btnEliminarProducto.setOnAction(e -> {
            String nombre = txtNombreProducto.getText();
            inventarioController.eliminarProducto(nombre);
            System.out.println("Producto eliminado: " + nombre);
            stage.close();
        });

        // Layout
        VBox vbox = new VBox(10, txtNombreProducto, txtDescripcion, txtPrecio, txtCantidad, btnAgregarProducto, btnEliminarProducto);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
