package servicios;

public class ServicioSpa extends Servicio {
    private boolean incluyeMasaje;

    public ServicioSpa(String nombre, double precioBase, boolean incluyeMasaje) {
        super(nombre, precioBase);
        this.incluyeMasaje = incluyeMasaje;
    }

    @Override
    public double calcularPrecioFinal() {
        // Si incluye masaje, sumamos un cargo extra fijo
        return incluyeMasaje ? precioBase + 50.0 : precioBase;
    }
}