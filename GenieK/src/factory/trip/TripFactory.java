package factory.trip;

import trip.Trip;

public abstract class TripFactory {

    protected abstract Trip fabricateTrip();

    public Trip createTrip(String id){

        Trip t = fabricateTrip();

        return t;
    }


}
