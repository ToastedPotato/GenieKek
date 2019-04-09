package company;

import station.Station;
import trip.Line;
import trip.Trip;

public class TrainCompany extends Company {

    public Line createLine(String id, int number, Station departure, Station arrived) {
        Trip t = super.createTrip(id, number, departure, arrived);
        return (Line) t;
    }

    public Line createLine(String id, int number, Station departure, Station arrived, Station[] stops) {
        Line t = createLine(id, number, departure, arrived);
        t.setStops(stops);
        return t;
    }

}
