package factory.trip;

import station.Station;
import trip.*;

public class FlightFactory extends TripFactory {

    private static FlightFactory instance = null;

    public static TripFactory getInstance() {
        if (instance == null) instance = new FlightFactory();
        return instance;
    }

    @Override
    protected Trip fabricateTrip() {
       return new Flight();
    }
}
