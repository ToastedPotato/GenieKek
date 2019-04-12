package company;

import exception.ExistException;
import exception.IdException;
import exception.TransportException;
import exception.TripException;
import factory.transport.*;
import factory.trip.TripFactory;
import reservation.Reservation;
import station.Station;
import transport.Transport;
import trip.Trip;
import ui.DataBase;
import visitor.Visitor;

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

    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public Transport createTransport(String transportId) {
        if (transportId.length() != 3) {
            try {
                throw new IdException(transportId);
            } catch (IdException ignored) { }
            return null;
        }
        if (DataBase.getInstance().transportExist(transportId)) {
            try {
                throw new ExistException(transportId);
            } catch (ExistException ignored) { }
            return null;
        }
        return transportFactory.createTransport(transportId, id);
    }

    public Trip createTrip(String tripId, int number, Station departure, Station arrived, String departureDate, String arrivalDate, String transportId) {
        if (tripId.length() != 2) {
            try {
                throw new IdException(tripId);
            } catch (IdException ignored) { }
            return null;
        }
        if (DataBase.getInstance().tripExist(tripId)) {
            try {
                throw new ExistException(tripId);
            } catch (ExistException ignored) { }
            return null;
        }
        Transport transport = getTransport(transportId);
        if (transport == null) return null;
        return tripFactory.createTrip(tripId, number, departure, arrived, id, departureDate, arrivalDate, transport);
    }

    public String transportToString(Visitor visitor) {
        String string = "";
        for (Transport transport : transports) {
            string += visitor.visit(transport) + "\n";
        }
        return string;
    }

    public String tripToString(Visitor visitor) {
        String string = "";
        for (Trip trip : trips) {
            string += visitor.visit(trip) + "\n";
        }
        return string;
    }

    public Transport getTransport(String transportId) {
        for (Transport transport : transports) {
            if (transport.getId().equals(transportId)) return transport;
        }
        try {
            throw new TransportException(transportId);
        } catch (TransportException ignored) { }
        return null;
    }

    public Trip getTrip(String tripId) {
        for (Trip trip : trips) {
            if (trip.getId().equals(tripId)) return trip;
        }
        try {
            throw new TripException(tripId);
        } catch (TripException ignored) { }
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
