package org.example.models;

public class Login {
    private String nombreUsuario;
    private String contrasena;
    private String tipoUsuario;

    // Constructor
    public Login(String nombreUsuario, String contrasena, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Método para iniciar sesión, devuelve el tipo de usuario (Cliente, Proveedor, etc.)
    public Object iniciarSesion(String usuario, String pass) {
        if (this.nombreUsuario.equals(usuario) && this.contrasena.equals(pass)) {
            System.out.println("Inicio de sesión exitoso como " + this.tipoUsuario);
            switch (this.tipoUsuario) {
                case "cliente":
                    // Asegúrate de que Cliente tiene el constructor adecuado
                    return new Cliente(1, "nombreCliente", "apellidoCliente", "direccionCliente", "dniCliente", "cliente@example.com", "123456789");
                case "proveedor":
                    // Asegúrate de que Proveedor tiene el constructor adecuado
                    return new Proveedor(2, "nombreProveedor", "apellidoProveedor", "direccionProveedor", "dniProveedor", "proveedor@example.com", "empresaProveedor", "987654321");
                default:
                    return null;  // Si no es un tipo de usuario válido
            }
        } else {
            System.out.println("Error: Nombre de usuario o contraseña incorrecta.");
            return null;
        }
    }
}
