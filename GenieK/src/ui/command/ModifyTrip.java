package ui.command;

import station.Station;
import trip.*;

public class ModifyTrip implements Command{

    private Trip target;
    private String oldId, newId, oldIdCompany, newIdCompany;
    private int oldNumber, newNumber;
    private Station oldDepart, oldArrive, newDepart, newArrive;
        
    public ModifyTrip(Trip target, String newId, int newNumber, Station newDepart, Station newArrive, String newIdCompany){
        this.target = target;
        
        this.oldId = target.getId();
        this.oldNumber = target.getNumber();
        this.oldDepart = target.getDepart();
        this.oldArrive = target.getArrive();
        this.oldIdCompany = target.getIdCompany();
        
        if(newId != null){this.newId = newId;}
        if(newNumber != 0){this.newNumber = newNumber;}
        if(newDepart != null){this.newDepart = newDepart;}
        if(newArrive != null){this.newArrive = newArrive;}
        if(newIdCompany != null){this.newIdCompany = newIdCompany;}
    }
    
    public void execute(){
        if(this.newId != null){this.target.setId(this.newId);}
        if(this.newNumber != 0){this.target.setNumber(this.newNumber);}
        if(this.newDepart != null && this.newArrive != null){this.target.setStation(this.newDepart, this.newArrive);}
        if(this.newIdCompany != null){this.target.setIdCompany(this.newIdCompany);}    
    }
    
    public void unexecute(){
        this.target.setId(this.oldId);
        this.target.setNumber(this.oldNumber);
        this.target.setStation(this.oldDepart, this.oldArrive);
        this.target.setIdCompany(this.oldIdCompany);    
    }

}
