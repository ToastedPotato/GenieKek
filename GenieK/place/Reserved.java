package place

public class Reserved implements State{
    
    public Reserved(){
        return;
    }
    
    public void manageRes(Place context, Reservation res){
        //Annulation de réservation        
        context.setReservation(null);
        context.setState(new Free());
        return;
    }
    
    public void payment(Place context, Confirmation conf){
        //paiement de réservation
        context.res.setConfirmation(conf);
        context.setState(new Confirmed());
        return;
    }

}
