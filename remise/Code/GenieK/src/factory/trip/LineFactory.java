package factory.trip;

import station.Station;
import trip.*;

public class LineFactory extends TripFactory {

    private static LineFactory instance = null;

    public static TripFactory getInstance() {
        if (instance == null) instance = new LineFactory();
        return instance;
    }

    @Override
    protected Trip fabricateTrip() {
        return new Line();
    }
}
