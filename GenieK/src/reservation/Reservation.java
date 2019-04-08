package reservation;

public class Reservation{
    
    private Confirmation confirmation;
    
    public Reservation(){
        this.confirmation = null;
    }
    
    public Confirmation getConfirmation(){
        return this.confirmation;
    }
    
    public void setConfirmation(Confirmation conf){
        this.confirmation = conf;
    }
    
}
