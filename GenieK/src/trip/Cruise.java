package trip;

import station.Station;

public class Cruise extends Trip {

    /*public Cruise(String id, int number, Station depart, Station arrive, String idCompany, Station[] stops) throws CruiseException {
        super(id, number, depart, arrive, idCompany, stops);

        if(!depart.equals(arrive)) throw new CruiseException();
    }*/

    @Override
    public void setStation(Station depart, Station arrive) {
        if(!depart.equals(arrive)) try {
            throw new CruiseException();
        } catch (CruiseException e) {
            e.printStackTrace();
        }
        super.setStation(depart, arrive);
    }
}
