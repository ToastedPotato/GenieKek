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
        
        this.oldId = this.target.getId();
        this.oldName = this.target.getName();
        this.oldCity = this.target.getCity();
        
        this.newId = newId;
        this.newName = newName;
        this.newCity = newCity;
    }
    
    public void execute(){
        if(!this.newId.equals("")){this.target.setId(this.newId);}
        if(!this.newName.equals("")){this.target.setName(this.newName);}
        if(!this.newCity.equals("")){this.target.setCity(this.newCity);}    
    }
    
    public void unexecute(){
        this.target.setId(this.oldId);
        this.target.setName(this.oldName);
        this.target.setCity(this.oldCity);    
    }

}
