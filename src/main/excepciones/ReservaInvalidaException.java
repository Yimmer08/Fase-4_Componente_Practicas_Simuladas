package excepciones;

public class ReservaInvalidaException extends SoftwareFJException {
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
}