package gestores;

import modelos.Cliente;
import servicios.Servicio;
import utilidades.LoggerSistema;
import excepciones.ReservaInvalidaException; // Verifica que el archivo exista en la carpeta excepciones

public class Reserva {
    private Cliente cliente;
    private Servicio servicio;
    private String estado;

    public Reserva(Cliente cliente, Servicio servicio) throws ReservaInvalidaException {
        try {
            if (cliente == null || servicio == null) {
                throw new ReservaInvalidaException("Datos insuficientes: Cliente o Servicio nulos.");
            }
            this.cliente = cliente;
            this.servicio = servicio;
            this.estado = "PENDIENTE";
        } catch (ReservaInvalidaException e) {
            LoggerSistema.registrarEvento("Fallo al crear reserva: " + e.getMessage());
            throw e; 
        } finally {
            System.out.println("Validando integridad de la operación de reserva...");
        }
    }

    public void confirmarReserva() {
        this.estado = "CONFIRMADA";
        LoggerSistema.registrarEvento("Reserva confirmada para " + cliente.getNombre());
    }

    public void mostrarDetalle() {
        System.out.println("Reserva [" + estado + "]: " + servicio.describirServicio());
        System.out.println("Total: $" + servicio.calcularCosto());
    }
}