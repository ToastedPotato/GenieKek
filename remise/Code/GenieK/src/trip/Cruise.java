package trip;

import exception.CruiseException;
import station.Station;

public class Cruise extends Trip {

    @Override
    public void setStation(Station depart, Station arrive) throws CruiseException {
        if(!depart.equals(arrive)) throw new CruiseException();
        super.setStation(depart, arrive);
    }
}
