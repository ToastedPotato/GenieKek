package factory.transport;

import transport.Train;
import transport.Transport;
import transport.section.OrganizableSection;

public class TrainFactory extends TransportFactory {

    private static TrainFactory instance = null;

    public static TransportFactory getInstance() {
        if (instance == null) instance = new TrainFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        return new Train(OrganizableSection.class);
    }
}
