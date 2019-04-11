package factory.transport;

import transport.*;
import transport.section.OrganizableSection;

public class PlaneFactory extends TransportFactory {

    private static PlaneFactory instance = null;

    public static TransportFactory getInstance() {
        if (instance == null) instance = new PlaneFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return new Plane(OrganizableSection.class);
    }
}
