package station;

public class PriceException extends Exception {

    public PriceException() {
        System.out.println("Le prix doit être supérieur à 0");
    }
}
