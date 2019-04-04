package place;

import place.state.*;
import reservation.*;

public abstract class Place{

    State state;
    public Reservation res;

    public Place() {
        this.state = new Free();
    }

    public void setReservation(Reservation res){
        this.res = res;
    }
    
    public void setState(State state){
        this.state = state;
    }


    public void manage(Reservation res){
        this.state.manage(this, res);

    }

    public void payement(Confirmation conf){
        this.state.payment(this, conf);

    }

}
