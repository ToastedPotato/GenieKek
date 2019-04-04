package factory.trip;

import station.Station;
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
    protected Trip fabricateTrip(Station[] stops) {
        TripWithStop t = new Cruise();
        t.setStops(stops);
        return t;
    }
}
