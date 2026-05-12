package utilidades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerSistema {
    private static final String RUTA_LOG = "logs/eventos.txt";

    public static void registrarError(String mensaje) {
        try (FileWriter fw = new FileWriter(RUTA_LOG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[" + LocalDateTime.now() + "] ERROR: " + mensaje);
        } catch (Exception e) {
            System.err.println("No se pudo escribir en el log: " + e.getMessage());
        }
    }

    public static void registrarEvento(String mensaje) {
        try (FileWriter fw = new FileWriter(RUTA_LOG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[" + LocalDateTime.now() + "] INFO: " + mensaje);
        } catch (Exception e) {
            System.err.println("No se pudo escribir en el log: " + e.getMessage());
        }
    }
}