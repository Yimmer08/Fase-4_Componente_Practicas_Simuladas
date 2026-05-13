package servicios;

public abstract class Servicio {
    protected String nombre;
    protected double precioBase;

    public Servicio(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método polimórfico (Abstracción)
    public abstract double calcularCosto();
    
    // Sobrecarga de métodos (Requisito: variante con descuento)
    public double calcularCosto(double descuentoEspecial) {
        return calcularCosto() - descuentoEspecial;
    }

    public abstract String describirServicio();
    
    public String getNombre() { return nombre; }
}