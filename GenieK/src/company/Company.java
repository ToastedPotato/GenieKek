package company;

import factory.transport.*;
import factory.trip.TripFactory;
import reservation.Reservation;
import station.Station;
import transport.Transport;
import trip.Trip;

import java.util.ArrayList;

public class Company {

    private TransportFactory transportFactory;
    private TripFactory tripFactory;
    private String id, name;
    private int price;
    private ArrayList<Trip> trips = new ArrayList<>();
    private ArrayList<Transport> transports = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void setTransportFactory(TransportFactory transportFactory) {
        this.transportFactory = transportFactory;
    }

    public void setTripFactory(TripFactory tripFactory) {
        this.tripFactory = tripFactory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transport createTransport(String id) {
        Transport t = transportFactory.createTransport(id);
        transports.add(t);
        return t;
    }

    public Trip createTrip(String id, int number, Station departure, Station arrived) {
        Trip t = tripFactory.createTrip(id, number, departure, arrived, id);
        trips.add(t);
        return t;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    // TODO : à supprimer, juste pour les tests
    public String toString() {
        StringBuilder string = new StringBuilder("[COMPANY :: " + name + "]\n-------------------\n");
        for(Trip trip : trips) {
            string.append(" - (")
                    .append(trip.getId())
                    .append(") ")
                    .append(trip.getDepart().getCity())
                    .append(" -> ")
                    .append(trip.getArrive().getCity())
                    .append("\n");

        }
        return string.toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

}
