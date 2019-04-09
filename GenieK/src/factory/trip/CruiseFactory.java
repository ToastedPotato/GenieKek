package factory.trip;

import station.Station;
import transport.Boat;
import trip.*;

public class CruiseFactory extends TripFactory {

    private static CruiseFactory instance = null;

    public static TripFactory getInstance() {
        if (instance == null) instance = new CruiseFactory();
        return instance;
    }


    @Override
    protected Trip fabricateTrip() {
        return new Cruise();
    }
}
