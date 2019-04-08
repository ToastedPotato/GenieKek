package place.state;

import place.Place;
import reservation.*;

public class Confirmed implements State{

    /**
     * Annule la réservation
     * @param place : la place
     * @param reservation : la réservation
     */
    public void manage(Place place, Reservation reservation){
        reservation.setPlace(null);
        place.setState(new Free());
    }

    /**
     * Paiement du siège
     * impossible ici
     * @param place : la place
     * @param confirmation : confirmation
     */
    public void payment(Place place, Confirmation confirmation, Reservation reservation){
        try {
            throw new StateException("Paiement impossible sur l'état Libre");
        } catch (StateException e) {
            e.printStackTrace();
        }
    }
}
