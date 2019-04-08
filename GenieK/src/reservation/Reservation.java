package reservation;

public class Reservation{
    
    private Confirmation confirmation;
    
    private Place place;
    
    public Reservation(){
        this.confirmation = null;
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
        return;
    }
    
}
