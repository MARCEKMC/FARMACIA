package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Farmacia Virtual - Menú Principal");

        // Botones de navegación
        Button btnLogin = new Button("Iniciar Sesión");
        Button btnProductos = new Button("Ver Productos");
        Button btnInventario = new Button("Gestionar Inventario");
        Button btnSalir = new Button("Salir");

        // Manejo de eventos
        btnLogin.setOnAction(e -> new LoginView().mostrar());
        btnProductos.setOnAction(e -> new ProductoView().mostrar());
        btnInventario.setOnAction(e -> new InventarioView().mostrar());
        btnSalir.setOnAction(e -> primaryStage.close());

        // Layout
        VBox vbox = new VBox(20, btnLogin, btnProductos, btnInventario, btnSalir);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Escena
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
