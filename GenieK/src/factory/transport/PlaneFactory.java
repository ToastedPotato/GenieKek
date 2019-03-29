package factory.transport;

import transport.*;

public class PlaneFactory extends TransportFactory {

    private static PlaneFactory instance = null;

    private PlaneFactory() {

    }

    public static TransportFactory getInstance() {
        if (instance == null) instance = new PlaneFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return null;
    }
}
