package servicios;

import utilidades.LoggerSistema; // Importamos tu logger

public abstract class Servicio {
    protected String nombre;
    protected double precioBase;

    public Servicio(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        
        // Generamos el evento para el log automáticamente al crear cualquier servicio
        LoggerSistema.registrarEvento("Nuevo servicio creado: " + nombre + " (Base: $" + precioBase + ")");
    }

    public abstract double calcularPrecioFinal();

    public String getInformacion() {
        return "Servicio: " + nombre + " | Precio Base: $" + precioBase;
    }
}