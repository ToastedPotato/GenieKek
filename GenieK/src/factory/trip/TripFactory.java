package factory.trip;

import exception.CruiseException;
import station.Station;
import transport.Transport;
import trip.*;

public abstract class TripFactory {

    protected abstract Trip fabricateTrip();

    public Trip createTrip(String id, Station departure, Station arrived, String companyId, String departureDate, String arrivalDate, Transport transport){
        Trip t = fabricateTrip();
        t.setId(id);
        t.setCompanyId(companyId);
        t.setTransport(transport);
        try {
            t.setStation(departure, arrived);
        } catch (CruiseException ignore) {
            return null;
        }
        t.setDepartureDate(departureDate);
        t.setArrivalDate(arrivalDate);
        return t;
    }

}
