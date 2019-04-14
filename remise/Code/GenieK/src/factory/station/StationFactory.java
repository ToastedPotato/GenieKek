package factory.station;

import exception.ExistException;
import exception.IdException;
import station.*;
import ui.DataBase;

public abstract class StationFactory {

    protected abstract Station fabricateStation();

    public Station createStation(String id, String city){
        if (id.length() != 3) {
            try {
                throw new IdException(id, 3);
            } catch (IdException ignored) { }
            return null;
        }
        if (DataBase.getInstance().stationExist(id)) {
            try {
                throw new ExistException(id);
            } catch (ExistException ignored) { }
            return null;
        }
        Station s = fabricateStation();
        s.setId(id);
        s.setCity(city);
        return s;
    }



}
