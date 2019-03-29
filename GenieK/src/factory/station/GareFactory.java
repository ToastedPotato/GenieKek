package factory.station;

import station.*;

public class GareFactory extends StationFactory {

    private static GareFactory instance = null;

    private GareFactory() {

    }

    public static StationFactory getInstance() {
        if (instance == null) instance = new GareFactory();
        return instance;
    }

    @Override
    protected Station fabricateStation() {
        return new Railway();
    }
}
