package bo.edu.uagrm.ficct.rubencano.Excepciones;

public class OrdenInvalidoExcepcion extends Exception {

    public OrdenInvalidoExcepcion() {
        super("El orden mínimo es 3");
    }

    public OrdenInvalidoExcepcion(String message) {
        super(message);
    }
}
