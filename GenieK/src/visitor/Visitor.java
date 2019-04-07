package company;
package station;
package transport;
package trip;


public interface Visitor {

    public String visit (Company company);
    public String visit (Place place);
    public String visit (Station station);
    public String visit (Transport transport);
    public String visit (Schedule schedule);
    public String visit (Trip trip);
    public String visit (TripWithStop tripWithStop)

        
}