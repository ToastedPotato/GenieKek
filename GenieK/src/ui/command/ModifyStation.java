package ui.command;

import station.*;

public class ModifyStation implements Command{

    private Station target;
    private String oldId, oldCity, newId, newCity;

    public ModifyStation(Station target, String newId, String newCity){
        this.target = target;
        
        this.oldId = target.getId();
        this.oldCity = target.getCity();
        
        if(newId != null){this.newId = newId;}
        if(newCity != null){this.newCity = newCity;}
    }
    
    public void execute(){
        if(this.newId != null){this.target.setId(this.newId);}
        if(this.newCity != null){this.target.setCity(this.newCity);}    
    }
    
    public void unexecute(){
        this.target.setId(this.oldId);
        this.target.setCity(this.oldCity);    
    }

}
