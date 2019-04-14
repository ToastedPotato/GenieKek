package place.state;

import place.Place;

public interface State{
    
    void manage(Place place);
    
    void payment(Place place);
}
