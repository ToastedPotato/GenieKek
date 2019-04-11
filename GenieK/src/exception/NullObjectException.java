package exception;

public class NullObjectException extends SystemException {

    public NullObjectException(String id) {
        super("L'objet [" + id + "] n'existe pas dans la base de données");
    }

}
