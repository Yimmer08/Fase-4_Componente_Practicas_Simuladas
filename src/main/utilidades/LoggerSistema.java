package utilidades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerSistema {
    private static final String ARCHIVO_LOG = "logs_softwarefj.txt";

    public static void registrarEvento(String mensaje) {
        try (FileWriter fw = new FileWriter(ARCHIVO_LOG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[" + LocalDateTime.now() + "] - " + mensaje);
        } catch (Exception e) {
            System.err.println("No se pudo escribir en el log: " + e.getMessage());
        }
    }
}