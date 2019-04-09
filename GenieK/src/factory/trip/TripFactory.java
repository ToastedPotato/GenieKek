package factory.trip;

import station.Station;
import transport.Transport;
import trip.*;

public abstract class TripFactory {

    protected abstract Trip fabricateTrip();

    public Trip createTrip(String id, int number, Station departure, Station arrived, String companyId, Transport transport){
        Trip t = fabricateTrip();
        t.setId(id);
        t.setNumber(number);
        t.setIdCompany(companyId);
        t.setTransport(transport);
        t.setStation(departure, arrived);
        return t;
    }

}
