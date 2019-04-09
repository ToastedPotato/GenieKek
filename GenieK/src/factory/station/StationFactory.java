package factory.station;

import station.*;

public abstract class StationFactory {

    protected abstract Station fabricateStation();

    public Station createStation(String id, String city){
        Station s = fabricateStation();
        s.setId(id);
        s.setCity(city);
        return s;
    }



}
