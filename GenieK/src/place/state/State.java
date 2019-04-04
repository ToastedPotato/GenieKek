package place.state;

import place.Place;
import reservation.*;

public interface State{
    
    void manage(Place place, Reservation reservation);
    
    void payment(Place place, Confirmation confirmation);
}
