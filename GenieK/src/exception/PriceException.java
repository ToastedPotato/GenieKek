package exception;

public class PriceException extends SystemException {

    public PriceException() {
        super("Le prix doit être supérieur à 0");
    }
}
