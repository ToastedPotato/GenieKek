package factory.transport;

import transport.*;

public class TrainFactory extends TransportFactory {

    private static TrainFactory instance = null;

    private TrainFactory() {

    }

    public static TransportFactory getInstance() {
        if (instance == null) instance = new TrainFactory();
        return instance;
    }

    @Override
    protected Transport fabricateTransport() {
        System.out.println("chouchou je suis un train");
        return new Train();
    }
}
