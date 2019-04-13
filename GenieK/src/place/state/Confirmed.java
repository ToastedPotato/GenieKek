package place.state;

import exception.StateException;
import place.Place;
import reservation.*;

public class Confirmed implements State{

    /**
     * Annule la réservation
     * @param place : la place
     */
    public void manage(Place place){
        place.setState(new Free());
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
