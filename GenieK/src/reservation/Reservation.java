package reservation;

public class Reservation{
    
    private static int number= 1;
    
    private String resNum;
    
    private Confirmation confirmation;
    
    private Place place;
    
    public Reservation(String idCompany){
        this.resNum = idCompany + number;
        number++;
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
