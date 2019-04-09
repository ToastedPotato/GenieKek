package company;

public class TransportException extends Exception {

    public TransportException(String transportId) {
        System.out.println("Transport [" + transportId + "] inexistant dans cette compagnie");
    }
}
