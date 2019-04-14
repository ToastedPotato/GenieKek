package place.state;

import place.Place;

public class Reserved implements State{

    /**
     * Annule la réservation
     * @param place : la place
     */
    public void manage(Place place) {
        place.setState(new Free());
    }

    /**
     * Procède au paiement de la place avec la confirmation
     * @param place : la place
     */
    public void payment(Place place){
        place.setState(new Confirmed());
    }

}
