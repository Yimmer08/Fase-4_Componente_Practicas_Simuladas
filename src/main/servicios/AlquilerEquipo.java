package servicios;

public class AlquilerEquipo extends Servicio {
    private int cantidad;

    public AlquilerEquipo(String nombre, double precioBase, int cantidad) {
        super(nombre, precioBase);
        this.cantidad = cantidad;
    }

    @Override
    public double calcularCosto() { return precioBase * cantidad; }

    @Override
    public String describirServicio() { return "Alquiler de " + cantidad + " unidades de " + nombre; }
}