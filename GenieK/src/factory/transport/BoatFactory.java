package factory.transport;

import transport.Transport;

public class BoatFactory extends TransportFactory {

    private static BoatFactory instance = null;

    private BoatFactory() {

    }

    public static TransportFactory getInstance() {
        if (instance == null) instance = new BoatFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return null;
    }
}
