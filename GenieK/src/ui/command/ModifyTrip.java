package ui.command;

import station.Station;
import trip.*;

public class ModifyTrip implements Command{

    private Trip trip;
    private String oldId, newId;
    private int oldNumber, newNumber;
    private Station oldDepart, oldArrive, newDepart, newArrive;
        
    public ModifyTrip(Trip trip, String newId, int newNumber, Station newDepart, Station newArrive){
        this.trip = trip;
        this.oldId = trip.getId();
        this.oldNumber = trip.getNumber();
        this.oldDepart = trip.getDepart();
        this.oldArrive = trip.getArrive();
        this.newId = newId;
        this.newNumber = newNumber;
        this.newDepart = newDepart;
        this.newArrive = newArrive;
    }
    
    public void execute(){
        this.trip.setId(this.newId);
        this.trip.setNumber(this.newNumber);
        this.trip.setStation(this.newDepart, this.newArrive);
    }
    
    public void unexecute(){
        this.trip.setId(this.oldId);
        this.trip.setNumber(this.oldNumber);
        this.trip.setStation(this.oldDepart, this.oldArrive);
    }

}
