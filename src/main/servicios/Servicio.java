package servicios;

public abstract class Servicio {
    protected String nombre;
    protected double precioBase;

    public Servicio(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método abstracto: cada servicio calculará su precio de forma distinta (Polimorfismo)
    public abstract double calcularPrecioFinal();

    public String getInformacion() {
        return "Servicio: " + nombre + " | Precio Base: $" + precioBase;
    }
}