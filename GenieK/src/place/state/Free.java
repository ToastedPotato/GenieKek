package place.state;

import place.Place;
import reservation.*;

public class Free implements State{

    /**
     * Change l'état
     * @param place : la place
     * @param reservation : réservation
     */
    public void manage(Place place, Reservation reservation){
        place.setReservation(reservation);
        place.setState(new Reserved());
    }

    /**
     * Paiement du siège
     * impossible ici
     * @param place : la place
     * @param confirmation : confirmation
     */
    public void payment(Place place, Confirmation confirmation){
        try {
            throw new StateException("Paiement impossible sur l'état Libre");
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

}
