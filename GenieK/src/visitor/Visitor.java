package visitor;

import company.Company;
import place.Place;
import reservation.Confirmation;
import reservation.Reservation;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.Disposition;
import transport.section.OrganizableSection;
import transport.section.Section;
import trip.*;

public interface Visitor {

    String visit (Company company);
    String visit (Station station);
    String visit (Transport transport);
    String visit (Trip trip);
    String visit (Confirmation confirmation);
    String visit (Reservation reservation);
    String visit (Trip trip, String sectionStr);
    String visit (OrganizableSection.Type type);
    String visit (CabinSection.Type type);
    String visit (Disposition dispo);

        
}