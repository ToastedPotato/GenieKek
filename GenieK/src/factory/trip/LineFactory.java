package factory.trip;

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
    protected Trip fabricateTrip() {
        System.out.println("chouchou je suis un train");
        return new Line();
    }
}
