package factory.trip;

import trip.*;

public class FlightFactory extends TripFactory {

    private static FlightFactory instance = null;

    private FlightFactory() {

    }

    public static TripFactory getInstance() {
        if (instance == null) instance = new FlightFactory();
        return instance;
    }

    @Override
    protected Trip fabricateTrip() {
        return new Flight();
    }
}
