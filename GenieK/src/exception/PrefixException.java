package exception;

public class PrefixException extends SystemException {

    public PrefixException(String prefix) {
        super("L'id [" + prefix + "] doit avoir 2 caractères");
    }
}
