package exception;

public class StopException extends SystemException {

    public StopException(String item) {
        super("La station [" + item + "] est déjà un arrêt");
    }
}
