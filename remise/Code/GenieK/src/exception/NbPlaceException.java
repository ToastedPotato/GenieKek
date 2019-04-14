package exception;

public class NbPlaceException extends SystemException {

    public NbPlaceException() {
        super("Le nombre de place doit être supérieur à 0");
    }
}
