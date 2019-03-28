package place

public class Free implements State{
    
    public Free(){
        return;
    }
    
    public void manageRes(Place context, Reservation res){
        //réserver
        context.setReservation(res);
        context.setState(new Reserved());
        return;
    }
    
    public void payment(Place context, Confirmation conf){
        return;
    }

}
