package exception;

public class NoCommandException extends SystemException {

    public NoCommandException() {
        super("Aucune commande sur la pile");
    }
}
