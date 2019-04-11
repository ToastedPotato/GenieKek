package exception;

public class TransportException extends SystemException {

    public TransportException(String transportId) {
        super("Transport [" + transportId + "] est inexistant dans cette compagnie");
    }
}
