package views;

import controllers.ProveedorController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Proveedor;

public class ProveedorView {
    private ProveedorController proveedorController;

    public ProveedorView() {
        this.proveedorController = new ProveedorController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Gestionar Proveedores");

        // Campos para ingresar datos del proveedor
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del Proveedor");
        TextField txtApellido = new TextField();
        txtApellido.setPromptText("Apellido del Proveedor");
        TextField txtDireccion = new TextField();
        txtDireccion.setPromptText("Dirección");
        TextField txtDni = new TextField();
        txtDni.setPromptText("DNI");
        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        TextField txtEmpresa = new TextField();
        txtEmpresa.setPromptText("Empresa");
        TextField txtCelular = new TextField();
        txtCelular.setPromptText("Celular");

        // Botón para agregar proveedor
        Button btnAgregarProveedor = new Button("Agregar Proveedor");

        // Manejo del evento de agregar proveedor
        btnAgregarProveedor.setOnAction(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();
            String dni = txtDni.getText();
            String correo = txtCorreo.getText();
            String empresa = txtEmpresa.getText();
            String celular = txtCelular.getText();

            Proveedor proveedor = new Proveedor(0, nombre, apellido, direccion, dni, correo, empresa, celular);
            proveedorController.agregarProveedor(proveedor);
            System.out.println("Proveedor agregado: " + nombre);

            // Limpiar los campos después de agregar
            txtNombre.clear();
            txtApellido.clear();
            txtDireccion.clear();
            txtDni.clear();
            txtCorreo.clear();
            txtEmpresa.clear();
            txtCelular.clear();
        });

        // Layout
        VBox vbox = new VBox(10, txtNombre, txtApellido, txtDireccion, txtDni, txtCorreo, txtEmpresa, txtCelular, btnAgregarProveedor);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
