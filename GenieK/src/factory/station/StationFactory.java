package factory.station;

import station.*;

public abstract class StationFactory {

    protected abstract Station fabricateStation();

    public Station createStation(String id, String name, String city){

        Station s = fabricateStation();
        s.setId(id);
        s.setName(name);
        s.setCity(city);

        return s;
    }



}
