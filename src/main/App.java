import servicios.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE HERENCIA Y POLIMORFISMO ===");

        // Creamos una lista de la clase abstracta
        List<Servicio> carritoDeServicios = new ArrayList<>();

        // Agregamos diferentes hijos (Polimorfismo en acción)
        carritoDeServicios.add(new ServicioHospedaje("Habitación Suite", 100.0, 3));
        carritoDeServicios.add(new ServicioSpa("Sesión Relax", 40.0, true));
        carritoDeServicios.add(new ServicioSpa("Sauna Básico", 20.0, false));

        double totalAcumulado = 0;

        for (Servicio s : carritoDeServicios) {
            double precioFinal = s.calcularPrecioFinal();
            System.out.println(s.getInformacion() + " -> Total: $" + precioFinal);
            totalAcumulado += precioFinal;
        }

        System.out.println("\nTOTAL A PAGAR POR EL CLIENTE: $" + totalAcumulado);
    }
}