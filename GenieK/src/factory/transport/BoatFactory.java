package factory.transport;

import place.Cabin;
import transport.Boat;
import transport.Transport;
import transport.section.CabinSection;

public class BoatFactory extends TransportFactory {

    private static BoatFactory instance = null;

    public static TransportFactory getInstance() {
        if (instance == null) instance = new BoatFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return new Boat(CabinSection.class);
    }
}
