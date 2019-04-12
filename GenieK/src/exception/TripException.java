package exception;

public class TripException extends SystemException {

    public TripException(String tripId) {
        super("Le voyage [" + tripId + "] n'existe pas");
    }
}
