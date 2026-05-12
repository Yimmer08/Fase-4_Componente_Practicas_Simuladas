package utilidades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerSistema {
    private static final String ARCHIVO_LOG = "logs/eventos.txt";

    public static void registrarEvento(String mensaje) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO_LOG, true))) {
            out.println(LocalDateTime.now() + " - " + mensaje);
        } catch (Exception e) {
            System.err.println("No se pudo escribir en el log: " + e.getMessage());
        }
    }
}