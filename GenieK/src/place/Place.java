package place;

import place.state.Confirmed;
import place.state.Free;
import place.state.Reserved;
import place.state.State;

public abstract class Place{

    private State state;
    private int requiredAnnulationTime;

    public Place(int requiredAnnulationTime) {
        this.state = new Free();
        this.requiredAnnulationTime = requiredAnnulationTime;
    }

    public int getRequiredAnnulationTime() {
        return requiredAnnulationTime;
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

    public void manage(){
        this.state.manage(this);
    }

    public void payement(){
        this.state.payment(this);
    }
}