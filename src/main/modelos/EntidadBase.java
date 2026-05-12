package modelos;

public abstract class EntidadBase {
    protected int id;

    public EntidadBase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método abstracto que obliga a todas las hijas a identificarse
    public abstract String obtenerDetalles();
}