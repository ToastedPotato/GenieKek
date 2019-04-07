package ui.command;

import trip.*;

public class ModifyTrip implements Command{

    Trip target;
    
    String oldId;
    int oldNumber;
    Station oldDepart;
    Station oldArrive;
    String oldIdCompany;
    
    String newId;
    int newNumber;
    Station newDepart;
    Station newArrive;
    String newIdCompany;
        
    public ModifyStation(Trip target, String newId, int newNumber, Station newDepart, Station newArrive, String newIdCompany){
        this.target = target;
        
        this.oldId = target.getId();
        this.oldNumber = target.getNumber();
        this.oldDepart = target.getDepart();
        this.oldArrive = target.getArrive();
        this.oldIdCompany = target.getIdCompany();
        
        if(newId != null){this.newId = newId;}
        if(newNumber != null){this.newNumber = newNumber;}
        if(newDepart != null){this.newDepart = newDepart;}
        if(newArrive != null){this.newArrive = newArrive;}
        if(newIdCompany != null){this.newIdCompany = newIdCompany;}
    }
    
    public void execute(){
        if(this.newId != null){this.target.setId(this.newId);}
        if(this.newNumber != null){this.target.setNumber(this.newNumber);}
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
