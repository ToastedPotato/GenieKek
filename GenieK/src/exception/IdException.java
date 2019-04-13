package exception;

public class IdException extends SystemException {

    public IdException(String id, int length) {
        super("L'id [" + id + "] doit avoir " + length + " caractères");
    }
}
