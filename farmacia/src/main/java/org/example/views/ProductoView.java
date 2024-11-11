package views;

import controllers.ProductoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Producto;

import java.util.List;

public class ProductoView {
    private ProductoController productoController;
    private ObservableList<String> productosList;

    public ProductoView() {
        this.productoController = new ProductoController();
        this.productosList = FXCollections.observableArrayList();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Gestión de Productos");

        // Lista de productos
        ListView<String> listViewProductos = new ListView<>(productosList);
        actualizarListaProductos();

        // Campos para agregar productos
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del Producto");
        TextField txtDescripcion = new TextField();
        txtDescripcion.setPromptText("Descripción");
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        TextField txtMetodoEntrega = new TextField();
        txtMetodoEntrega.setPromptText("Método de Entrega");

        // Botones
        Button btnAgregar = new Button("Agregar Producto");
        Button btnEliminar = new Button("Eliminar Producto");
        Button btnRefrescar = new Button("Refrescar Lista");

        // Manejo de eventos
        btnAgregar.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            String metodoEntrega = txtMetodoEntrega.getText();

            productoController.agregarProducto(0, nombre, descripcion, precio, metodoEntrega);
            actualizarListaProductos();

            // Limpiar campos
            txtNombre.clear();
            txtDescripcion.clear();
            txtPrecio.clear();
            txtMetodoEntrega.clear();
        });

        btnEliminar.setOnAction(e -> {
            String productoSeleccionado = listViewProductos.getSelectionModel().getSelectedItem();
            if (productoSeleccionado != null) {
                int idProducto = Integer.parseInt(productoSeleccionado.split(":")[0]);
                productoController.eliminarProducto(idProducto);
                actualizarListaProductos();
            }
        });

        btnRefrescar.setOnAction(e -> actualizarListaProductos());

        // Layout
        HBox hboxInputs = new HBox(10, txtNombre, txtDescripcion, txtPrecio, txtMetodoEntrega);
        VBox vbox = new VBox(10, listViewProductos, hboxInputs, btnAgregar, btnEliminar, btnRefrescar);
        hboxInputs.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    // Método para actualizar la lista de productos
    private void actualizarListaProductos() {
        productosList.clear();
        List<Producto> productos = productoController.listarProductos();
        for (Producto producto : productos) {
            productosList.add(producto.getId() + ": " + producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
}
