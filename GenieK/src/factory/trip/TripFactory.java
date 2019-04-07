package factory.trip;

import station.Station;
import trip.*;

public abstract class TripFactory {

    protected abstract Trip fabricateTrip(Station[] stops);

    protected abstract Trip fabricateTrip();

    public Trip createTrip(String id, int number, Station depart, Station arrive, String idCompany,Station[] stops){

        Trip t = fabricateTrip(stops);
        t.setId(id);
        t.setNumber(number);
        t.setIdCompany(idCompany);
        try {
            t.setStation(depart, arrive);
        } catch (CruiseException e) {
            e.printStackTrace();
        }

        return t;
    }

    public Trip createTrip(String id, int number, Station depart, Station arrive, String idCompany){

        Trip t = fabricateTrip();
        t.setId(id);
        t.setNumber(number);
        t.setIdCompany(idCompany);
        try {
            t.setStation(depart, arrive);
        } catch (CruiseException e) {
            e.printStackTrace();
        }

        return t;
    }

}
