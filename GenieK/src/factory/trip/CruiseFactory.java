package factory.trip;

import trip.*;

public class CruiseFactory extends TripFactory {

    private static CruiseFactory instance = null;

    private CruiseFactory() {

    }

    public static TripFactory getInstance() {
        if (instance == null) instance = new CruiseFactory();
        return instance;
    }

    @Override
    protected Trip fabricateTrip() {
        return new Cruise();
    }
}
