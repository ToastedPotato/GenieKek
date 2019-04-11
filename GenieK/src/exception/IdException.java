package exception;

public class IdException extends SystemException {

    public IdException(String id) {
        super("L'id [" + id + "] doit avoir 3 caractères");
    }
}
