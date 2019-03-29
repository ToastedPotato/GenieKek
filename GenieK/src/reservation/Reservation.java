package reservation;

public class Reservation{
    
    private Confirmation conf;
    
    public Reservation(){
        this.conf = null;
        return;
    }
    
    public Confirmation getConfirmation(){
        return this.conf;
    }
    
    public void setConfirmation(Confirmation conf){
        this.conf = conf;
        return;
    }
    
}
