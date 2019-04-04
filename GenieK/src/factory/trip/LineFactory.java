package factory.trip;

import station.Station;
import trip.*;

public class LineFactory extends TripFactory {

    private static LineFactory instance = null;

    private LineFactory() {

    }

    public static TripFactory getInstance() {
        if (instance == null) instance = new LineFactory();
        return instance;
    }

    @Override
    protected Trip fabricateTrip(Station[] stops) {
        TripWithStop t = new Line();
        t.setStops(stops);
        return t;
    }
}
