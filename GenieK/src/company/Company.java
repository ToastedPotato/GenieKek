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

    public Transport createTransport(String transportId) {
        Transport transport = transportFactory.createTransport(transportId);
        transports.add(transport);
        return transport;
    }

    public Trip createTrip(String tripId, int number, Station departure, Station arrived, String transportId) {
        Transport transport = getTransport(transportId);
        try {
            if (transport == null) throw new TransportException(transportId);
        } catch (TransportException e) {
            e.printStackTrace();
        }
        Trip trip = tripFactory.createTrip(tripId, number, departure, arrived, tripId, transport);
        trips.add(trip);
        return trip;
    }

    public Transport getTransport(String transportId) {
        for (Transport transport : transports) {
            if (transport.getId().equals(transportId)) return transport;
        }
        return null;
    }

    public boolean haveTrip(String tripId) {
        for (Trip trip : trips) {
            if (trip.getId().equals(tripId)) return true;
        }
        return false;
    }

    public Reservation reservedPlace(String tripId, String sectionId) {
        return null;
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
