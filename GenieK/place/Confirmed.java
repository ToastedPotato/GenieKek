package place

public class Confirmed implements State{
    
    public Confirmed(){
        return;
    }
    
    public void manageRes(Place context, Reservation res){
        //annulation
        context.setReservation(null);
        context.setState(new Free());
        return;
    }
    
    public void payment(Place context, Confirmation conf){
        return;
    }

}
