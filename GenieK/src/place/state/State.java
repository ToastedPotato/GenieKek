package place.state;

import place.Place;
import reservation.*;

public interface State{
    
    void manage(Place place);
    
    void payment(Place place);
}
