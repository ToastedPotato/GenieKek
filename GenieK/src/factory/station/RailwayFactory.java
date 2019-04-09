package factory.station;

import station.*;

public class RailwayFactory extends StationFactory {

    private static RailwayFactory instance = null;

    public static StationFactory getInstance() {
        if (instance == null) instance = new RailwayFactory();
        return instance;
    }

    @Override
    protected Station fabricateStation() {
        return new Railway();
    }
}
