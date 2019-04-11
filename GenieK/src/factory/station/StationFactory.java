package factory.station;

import exception.IdException;
import station.*;

public abstract class StationFactory {

    protected abstract Station fabricateStation();

    public Station createStation(String id, String city){
        if (id.length() != 3) {
            try {
                throw new IdException(id);
            } catch (IdException ignored) { }
        }
        Station s = fabricateStation();
        s.setId(id);
        s.setCity(city);
        return s;
    }



}
