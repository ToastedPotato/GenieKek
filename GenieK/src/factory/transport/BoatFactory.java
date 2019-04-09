package factory.transport;

import transport.Boat;
import transport.Transport;

public class BoatFactory extends TransportFactory {

    private static BoatFactory instance = null;

    public static TransportFactory getInstance() {
        if (instance == null) instance = new BoatFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return new Boat();
    }
}
