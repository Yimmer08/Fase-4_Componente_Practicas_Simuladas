package modelos;

import excepciones.ClienteInvalidoException;
import utilidades.LoggerSistema;

public class Cliente {
    private int id;
    private String nombre;
    private String email;

    public Cliente(int id, String nombre, String email) throws ClienteInvalidoException {
        if (!email.contains("@")) {
            String error = "Email inválido para el cliente: " + nombre;
            LoggerSistema.registrarEvento(error); // Guarda el error en el log
            throw new ClienteInvalidoException(error);
        }
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        LoggerSistema.registrarEvento("Cliente creado: " + nombre);
    }

    public String getDetalles() {
        return "ID: " + id + " | Nombre: " + nombre + " | Email: " + email;
    }
}