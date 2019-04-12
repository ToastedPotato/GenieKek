package reservation;

import place.Place;
import place.state.Reserved;

public class Reservation{
    
    private static int number = 1;
    private String resNum;
    private Confirmation confirmation;
    private Place place;
    
    public Reservation(String idCompany, Place place) {
        this.resNum = idCompany + number;
        number++;
        this.place = place;
        place.setState(new Reserved());
        this.confirmation = null;
    }

    public String getResNum() {
        return resNum;
    }

    public Confirmation getConfirmation(){
        return this.confirmation;
    }
    
    public void setConfirmation(Confirmation conf){
        this.confirmation = conf;
    }
    
    public Place getPlace(){
        return this.place;
    }
    
    public void setPlace(Place place){
        this.place = place;
    }
    
}
