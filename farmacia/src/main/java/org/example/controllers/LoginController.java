package org.example.controllers;

import org.example.models.Login;

public class LoginController {
    private Login login;

    public LoginController() {
        // Inicializamos las credenciales por defecto para el proveedor
        login = new Login("proveedor1", "proveedor123", "proveedor");  // Proveedor por defecto
    }

    public Object iniciarSesion(String nombreUsuario, String contrasena) {
        return login.iniciarSesion(nombreUsuario, contrasena);
    }
}
