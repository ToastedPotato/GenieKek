package factory.station;

import station.*;

public class AeroportFactory extends StationFactory {

    private static AeroportFactory instance = null;

    public static StationFactory getInstance() {
        if (instance == null) instance = new AeroportFactory();
        return instance;
    }

    protected Station fabricateStation(){
        return new Aeroport();
    }
}
