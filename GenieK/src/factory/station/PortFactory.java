package factory.station;

import station.*;

public class PortFactory extends StationFactory {

    private static PortFactory instance = null;

    public static StationFactory getInstance() {
        if (instance == null) instance = new PortFactory();
        return instance;
    }

    @Override
    protected Station fabricateStation() {
        return new Port();
    }
}
