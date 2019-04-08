package place.state;

import place.Place;
import reservation.*;

public class Reserved implements State{

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
     * Procède au paiement de la place avec la confirmation
     * @param place : la place
     * @param confirmation : la confirmation
     */
    public void payment(Place place, Confirmation confirmation, Reservation reservation){
        reservation.setConfirmation(confirmation);
        place.setState(new Confirmed());
    }

}
