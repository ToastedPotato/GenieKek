package place

public class Seat extends Place{
    
    public Seat(){
        this.state = new Free();
        return;
    }
    
    public void setReservation(Reservation res){
        this.res = res;
        return;
    }
    
    public void setState(State state){
        this.state = state;
        return;
    }
    
    public void manageReservation(Reservation res){
        this.state.manageRes(this, res);
        return;
    }
    
    public void processPayment(Confirmation conf){
        this.state.payment(this, conf);
        return;
    }
        
}
