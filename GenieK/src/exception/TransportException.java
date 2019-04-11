package exception;

public class TransportException extends SystemException {

    public TransportException(String transportId) {
        super("Transport [" + transportId + "] n'existe pas dans cette compagnie");
    }
}
