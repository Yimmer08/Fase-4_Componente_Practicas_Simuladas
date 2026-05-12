import servicios.*;
import utilidades.LoggerSistema;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA 2: SERVICIOS Y LOGS ===");
        LoggerSistema.registrarEvento("--- Iniciando simulación de servicios ---");

        List<Servicio> lista = new ArrayList<>();

        // Al crear estos objetos, se dispara el log dentro del constructor de Servicio
        lista.add(new ServicioHospedaje("Habitación VIP", 200.0, 2));
        lista.add(new ServicioSpa("Masaje Terapéutico", 60.0, true));

        for (Servicio s : lista) {
            double total = s.calcularPrecioFinal();
            String detalle = "Procesando: " + s.getInformacion() + " -> Total: $" + total;
            
            System.out.println(detalle);
            
            // Registramos el cálculo final en el log también
            LoggerSistema.registrarEvento(detalle);
        }

        LoggerSistema.registrarEvento("--- Fin de la simulación ---");
        System.out.println("\nPrueba finalizada. Revisa la carpeta 'logs' para ver el historial.");
    }
}