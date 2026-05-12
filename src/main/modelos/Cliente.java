package modelos;

import excepciones.ClienteInvalidoException;
import utilidades.LoggerSistema;

public class Cliente extends EntidadBase {
    private String nombre;
    private String email;
    private String telefono;

    // CONSTRUCTOR: Aquí aplicas la primera barrera de validación
    public Cliente(int id, String nombre, String email, String telefono) throws ClienteInvalidoException {
        super(id);
        setNombre(nombre); // Usamos el setter para centralizar la validación
        setEmail(email);
        this.telefono = telefono;
        
        LoggerSistema.registrarEvento("Cliente creado exitosamente: " + nombre);
    }

    // GETTERS Y SETTERS con Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ClienteInvalidoException {
        if (nombre == null || nombre.trim().length() < 3) {
            String msg = "Validación fallida: El nombre debe tener al menos 3 caracteres.";
            LoggerSistema.registrarError(msg);
            throw new ClienteInvalidoException(msg);
        }
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ClienteInvalidoException {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            String msg = "Validación fallida: Formato de correo electrónico inválido (" + email + ").";
            LoggerSistema.registrarError(msg);
            throw new ClienteInvalidoException(msg);
        }
        this.email = email;
    }

    // Implementación del método abstracto de EntidadBase
    @Override
    public String obtenerDetalles() {
        return String.format("ID: %d | Cliente: %s | Email: %s", id, nombre, email);
    }
}