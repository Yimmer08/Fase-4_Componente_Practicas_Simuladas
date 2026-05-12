package servicios;

public class ServicioHospedaje extends Servicio {
    private int noches;

    public ServicioHospedaje(String nombre, double precioBase, int noches) {
        super(nombre, precioBase);
        this.noches = noches;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * noches; // Lógica específica de hospedaje
    }
}