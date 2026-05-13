import modelos.Cliente;
import servicios.*;
import gestores.Reserva;
import excepciones.*;
import utilidades.LoggerSistema;

public class App {
    public static void main(String[] args) {
        System.out.println(">>> INICIANDO SISTEMA SOFTWARE FJ <<<");
        LoggerSistema.registrarEvento("Sistema iniciado - Ejecutando pruebas de robustez");

        // Simulación de 10 casos de prueba (Operaciones completas)
        for (int i = 1; i <= 10; i++) {
            System.out.println("\n--- Procesando Operación #" + i + " ---");
            try {
                ejecutarPrueba(i);
            } catch (Exception e) {
                // Captura cualquier error no controlado para que el ciclo FOR no se rompa
                System.out.println("CUIDADO: Error crítico en operación " + i + ": " + e.getMessage());
            } finally {
                System.out.println("Estado: Sistema estable. Listo para la siguiente tarea.");
            }
        }
        System.out.println("\n>>> PRUEBAS FINALIZADAS - REVISE logs_softwarefj.txt <<<");
    }

    private static void ejecutarPrueba(int id) throws SoftwareFJException, SoftwareFJException, ReservaInvalidaException {
        switch (id) {
            case 1: // ÉXITO: Reserva de Sala
                Cliente c1 = new Cliente("Yimmer Mezu", "yimmer@fj.com", "1061");
                Reserva r1 = new Reserva(c1, new ReservaSala("Sala de Juntas", 50.0, 3));
                r1.confirmarReserva();
                r1.mostrarDetalle();
                break;

            case 2: // ERROR: Email inválido
                System.out.println("Intentando registrar cliente con email corrupto...");
                Cliente c2 = new Cliente("Error Test", "email-sin-arroba", "000");
                break;

            case 3: // ÉXITO: Alquiler de Equipo con sobrecarga (Descuento)
                Cliente c3 = new Cliente("Ana Ruiz", "ana@fj.com", "2022");
                Servicio s3 = new AlquilerEquipo("Proyector 4K", 30.0, 2);
                System.out.println("Aplicando descuento especial del 10%...");
                double totalConDescuento = s3.calcularCosto(6.0); // Uso de sobrecarga
                System.out.println("Total con descuento: $" + totalConDescuento);
                break;

            case 4: // ERROR: Reserva con parámetros nulos
                System.out.println("Intentando crear reserva sin servicio...");
                Reserva r4 = new Reserva(new Cliente("Luis", "l@fj.com", "333"), null);
                break;

            case 5: // ÉXITO: Asesoría Virtual
                Cliente c5 = new Cliente("Carlos Sol", "c@fj.com", "444");
                Reserva r5 = new Reserva(c5, new Asesoria("Auditoría de Software", 200.0, false));
                r5.confirmarReserva();
                r5.mostrarDetalle();
                break;

            // Agrega aquí los casos del 6 al 10 siguiendo esta misma lógica...
            default:
                System.out.println("Ejecutando operación de rutina válida...");
                Cliente cDefault = new Cliente("Cliente " + id, "c" + id + "@fj.com", "ID-" + id);
                new Reserva(cDefault, new ReservaSala("Espacio Coworking", 20.0, 1)).confirmarReserva();
                break;
        }
    }
}