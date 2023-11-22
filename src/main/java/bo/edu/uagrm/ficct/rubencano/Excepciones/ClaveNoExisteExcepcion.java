package bo.edu.uagrm.ficct.rubencano.Excepciones;

public class ClaveNoExisteExcepcion extends Exception {

    public ClaveNoExisteExcepcion(){

    }

    public ClaveNoExisteExcepcion (String message){
        super(message);
    }
}
