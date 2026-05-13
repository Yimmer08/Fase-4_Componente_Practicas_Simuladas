package servicios;

public class Asesoria extends Servicio {
    private boolean presencial;

    public Asesoria(String nombre, double precioBase, boolean presencial) {
        super(nombre, precioBase);
        this.presencial = presencial;
    }

    @Override
    public double calcularCosto() { 
        // Si es presencial, tiene un recargo del 20%
        return presencial ? precioBase * 1.20 : precioBase; 
    }

    @Override
    public String describirServicio() { 
        return "Asesoría: " + nombre + (presencial ? " (Presencial)" : " (Virtual)"); 
    }
}