package trip;

import station.Station;

public class Cruise extends TripWithStop {
    public Cruise(String id, int number, Station depart, Station arrive, String idCompany, Station[] stops) throws CruiseException {
        super(id, number, depart, arrive, idCompany, stops);

        if(!depart.equals(arrive)) throw new CruiseException();
    }

    public Cruise(){
        super();
    }

    @Override
    public void setStation(Station depart, Station arrive) throws CruiseException {
        super.setStation(depart, arrive);
        if(!depart.equals(arrive)) throw new CruiseException();
    }
}
