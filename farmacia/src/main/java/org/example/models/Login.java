package models;

public class Login {
    private String nombreUsuario;
    private String contrasena;
    private String tipoUsuario; // Ejemplo: "cliente", "proveedor", "admin"

    // Constructor
    public Login(String nombreUsuario, String contrasena, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    // Métodos getters y setters
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

    // Método para iniciar sesión (simple, se podría mejorar con validaciones)
    public boolean iniciarSesion(String usuario, String password) {
        return this.nombreUsuario.equals(usuario) && this.contrasena.equals(password);
    }

    @Override
    public String toString() {
        return "Login{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
