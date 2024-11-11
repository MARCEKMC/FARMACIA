package controllers;

import models.Login;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    private Map<String, Login> usuarios;

    // Constructor
    public LoginController() {
        this.usuarios = new HashMap<>();
        inicializarUsuarios();
    }

    // Método para inicializar algunos usuarios de prueba
    private void inicializarUsuarios() {
        usuarios.put("admin", new Login("admin", "admin123", "Administrador"));
        usuarios.put("proveedor", new Login("proveedor", "prov123", "Proveedor"));
        usuarios.put("cliente", new Login("cliente", "cliente123", "Cliente"));
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        if (usuarios.containsKey(nombreUsuario)) {
            Login login = usuarios.get(nombreUsuario);
            if (login.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Tipo de usuario: " + login.getTipoUsuario());
                return true;
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
        return false;
    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(String nombreUsuario, String contrasena, String tipoUsuario) {
        if (!usuarios.containsKey(nombreUsuario)) {
            usuarios.put(nombreUsuario, new Login(nombreUsuario, contrasena, tipoUsuario));
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(String nombreUsuario) {
        if (usuarios.containsKey(nombreUsuario)) {
            usuarios.remove(nombreUsuario);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }
}
