package servicios;

public class ReservaSala extends Servicio {
    private int horas;

    public ReservaSala(String nombre, double precioBase, int horas) {
        super(nombre, precioBase);
        this.horas = horas;
    }

    @Override
    public double calcularCosto() { return precioBase * horas; }

    @Override
    public String describirServicio() { return "Reserva de Sala '" + nombre + "' por " + horas + " horas."; }
}