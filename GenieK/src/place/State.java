package place;

import reservation.*;

public interface State{
    
    public void manageRes(Place context, Reservation res);
    
    public void payment(Place context, Confirmation conf);
}
