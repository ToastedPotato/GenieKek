package trip;

import station.Station;

public abstract class TripWithStop extends Trip {

    private Station[] stops;

    public TripWithStop(String id, int number, Station depart, Station arrive, String idCompany, Station[] stops) {
        super(id,number, depart, arrive, idCompany);
        this.stops = stops;
    }

    public TripWithStop() {
        super();
    }

    public void setStops(Station[] stops) {
        this.stops = stops;
    }
}
