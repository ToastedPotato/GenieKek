package place;

import place.state.*;
import reservation.*;

public abstract class Place{

    private State state;
    
    public Place() {
        this.state = new Free();
    }
    
    public void setState(State state){
        this.state = state;
    }

    public boolean isFree() {
        return state instanceof Free;
    }

    public boolean isReserved() {
        return state instanceof Reserved;
    }

    public boolean isConfirmed() {
        return state instanceof Confirmed;
    }

    public void manage(Reservation res){
        this.state.manage(this, res);
    }

    public void payement(Confirmation conf, Reservation res){
        this.state.payment(this, conf, res);
    }
}