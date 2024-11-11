package views;

import controllers.LoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private LoginController loginController;

    public LoginView() {
        this.loginController = new LoginController();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Iniciar Sesión");

        // Componentes de la interfaz
        Label lblUsuario = new Label("Usuario:");
        TextField txtUsuario = new TextField();
        Label lblContrasena = new Label("Contraseña:");
        PasswordField txtContrasena = new PasswordField();
        Button btnIngresar = new Button("Ingresar");
        Label lblMensaje = new Label();

        // Manejo del evento de inicio de sesión
        btnIngresar.setOnAction(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = txtContrasena.getText();
            boolean autenticado = loginController.iniciarSesion(usuario, contrasena);

            if (autenticado) {
                lblMensaje.setText("Inicio de sesión exitoso.");
                new MainView().start(stage);
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos.");
            }
        });

        // Layout
        VBox vbox = new VBox(10, lblUsuario, txtUsuario, lblContrasena, txtContrasena, btnIngresar, lblMensaje);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20;");

        // Escena
        Scene scene = new Scene(vbox, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}
