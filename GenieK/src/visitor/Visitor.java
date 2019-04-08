package visitor;

import company.Company;
import place.Place;
import station.Station;
import transport.Transport;
import trip.*;

public interface Visitor {

    public String visit (Company company);
    public String visit (Place place);
    public String visit (Station station);
    public String visit (Transport transport);
    public String visit (Schedule schedule);
    public String visit (Trip trip);
    public String visit (TripWithStop tripWithStop);

        
}