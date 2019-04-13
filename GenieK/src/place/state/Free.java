package place.state;

import exception.StateException;
import place.Place;

public class Free implements State{

    /**
     * Change l'état
     * @param place : la place
     */
    public void manage(Place place) {
        place.setState(new Reserved());
    }

    /**
     * Paiement du siège
     * impossible ici
     * @param place : la place
     */
    public void payment(Place place){
        try {
            throw new StateException("Paiement impossible sur l'état Libre");
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

}
