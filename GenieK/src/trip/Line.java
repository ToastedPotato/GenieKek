package trip;

import station.Station;

public class Line extends TripWithStop {


    public Line(String id, int number, Station depart, Station arrive, String idCompany, Station[] stops) {
        super(id, number, depart, arrive, idCompany, stops);
    }

    public Line() {
        super();
    }
}
