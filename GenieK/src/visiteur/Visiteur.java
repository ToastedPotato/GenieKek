package company;
package station;
package transport;
package trip;


public interface Visiteur {

    public void visit (Company company);
    public void visit (Place place);
    public void visit (Station station);
    public void visit (Transport transport);
    public void visit (Schedule schedule);
    public void visit (Trip trip);
    public void visit (TripWithStop)


}