package ui.command;

import exception.IdException;
import station.*;

public class ModifyStation implements Command{

    private Station station;
    private String oldId, oldCity, newId, newCity;

    public ModifyStation(Station station, String newId, String newCity){
        if (newId.length() != 3) {
            try {
                throw new IdException(newId, 3);
            } catch (IdException ignored) { }
        }
        this.station = station;
        this.oldId = station.getId();
        this.oldCity = station.getCity();
        this.newId = newId;
        this.newCity = newCity;
    }
    
    public boolean execute(){
        this.station.setId(this.newId);
        this.station.setCity(this.newCity);
        return true;
    }
    
    public boolean unexecute(){
        this.station.setId(this.oldId);
        this.station.setCity(this.oldCity);
        return true;
    }

}
