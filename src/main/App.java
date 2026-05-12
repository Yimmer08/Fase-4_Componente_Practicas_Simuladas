package main;

import modelos.Cliente;
import excepciones.ClienteInvalidoException;
import utilidades.LoggerSistema;

public class App {
    public static void main(String[] args) {
        System.out.println("--- INICIO DE SIMULACIÓN DE REGISTRO DE CLIENTES ---");

        // CASO 1: Registro Válido
        try {
            System.out.println("\n[Simulación] Intentando registrar cliente válido...");
            Cliente cliente1 = new Cliente(1, "Juan Perez", "juan.perez@email.com", "3001234567");
            System.out.println("ÉXITO: " + cliente1.obtenerDetalles());
        } catch (ClienteInvalidoException e) {
            System.out.println("ERROR INESPERADO: " + e.getMessage());
        }

        // CASO 2: Registro Inválido (Email sin formato correcto)
        // Esto demostrará el uso de try-catch y el registro en el log.
        try {
            System.out.println("\n[Simulación] Intentando registrar cliente con email inválido...");
            Cliente cliente2 = new Cliente(2, "Maria Lopez", "maria-gmail-com", "3109876543");
            System.out.println("ÉXITO: " + cliente2.obtenerDetalles());
        } catch (ClienteInvalidoException e) {
            // Aquí cumples con: "manteniendo la aplicación activa y estable"
            System.err.println("CAPTURA DE ERROR: No se pudo crear el cliente. Motivo: " + e.getMessage());
            System.out.println("INFO: La aplicación sigue funcionando correctamente...");
        }

        System.out.println("\n--- FIN DE LA PRUEBA INICIAL ---");
        System.out.println("Revisa el archivo 'logs/eventos.txt' para ver el registro oficial.");
    }
}