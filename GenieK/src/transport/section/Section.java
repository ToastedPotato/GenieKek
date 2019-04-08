package transport.section;

import place.Place;

public class Section {

    private int nbPlaces;
    private float ratio;
    protected Place[] places;

    public Section(int nbPlaces, float ratio) {
        this.nbPlaces = nbPlaces;
        this.ratio = ratio;
        this.places = new Place[nbPlaces];
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public float getRatio() {
        return ratio;
    }

    public int getNbPlacesDispo() {
        int nb = 0;
        for(Place place : places)
            if (place.isFree()) nb++;
        return nb;
    }

}
