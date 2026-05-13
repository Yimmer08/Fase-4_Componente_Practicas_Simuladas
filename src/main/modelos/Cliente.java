package modelos;

import excepciones.SoftwareFJException;

public class Cliente {
    // Atributos privados (Encapsulación)
    private String nombre;
    private String email;
    private String cedula;

    public Cliente(String nombre, String email, String cedula) throws SoftwareFJException {
        // Validaciones robustas
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new SoftwareFJException("El nombre del cliente no puede estar vacío.");
        }
        if (email == null || !email.contains("@")) {
            throw new SoftwareFJException("El correo '" + email + "' no tiene un formato válido.");
        }
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + " | ID: " + cedula;
    }
}