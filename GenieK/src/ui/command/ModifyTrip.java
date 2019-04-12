package ui.command;

import transport.Transport;
import trip.Trip;

public class ModifyTrip implements Command{

    private Trip trip;
    private String newDepartureDate, oldDepartureDate, newArrivalDate, oldArrivalDate;
    private Transport newTransport, oldTransport;
        
    public ModifyTrip(Trip trip, String newDepartureDate, String newArrivalDate, Transport newTransport){
        this.trip = trip;
        this.newDepartureDate = newDepartureDate;
        this.oldDepartureDate = trip.getDepartureDateToString();
        this.newArrivalDate = newArrivalDate;
        this.oldArrivalDate = trip.getArrivedDateToString();
        this.newTransport = newTransport;
        this.oldTransport = trip.getTransport();
    }
    
    public void execute(){
        this.trip.setTransport(newTransport);
        this.trip.setDepartureDate(newDepartureDate);
        this.trip.setArrivalDate(newArrivalDate);
    }
    
    public void unexecute(){
        this.trip.setTransport(oldTransport);
        this.trip.setDepartureDate(oldDepartureDate);
        this.trip.setArrivalDate(oldArrivalDate);
    }

}
