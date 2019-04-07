package ui.command;

import station.*;

public class ModifyStation implements Command{

    Station target;
    
    String oldId;
    String oldName;
    String oldCity;
    
    String newId;
    String newName;
    String newCity;
        
    public ModifyStation(Station target, String newId, String newName, String newCity){
        this.target = target;
        
        this.oldId = target.getId();
        this.oldName = target.getName();
        this.oldCity = target.getCity();
        
        if(newId != null){this.newId = newId;}
        if(newName != null){this.newName = newName;}
        if(newCity != null){this.newCity = newCity;}
    }
    
    public void execute(){
        if(this.newId != null){this.target.setId(this.newId);}
        if(this.newName != null){this.target.setName(this.newName);}
        if(this.newCity != null){this.target.setCity(this.newCity);}    
    }
    
    public void unexecute(){
        this.target.setId(this.oldId);
        this.target.setName(this.oldName);
        this.target.setCity(this.oldCity);    
    }

}
