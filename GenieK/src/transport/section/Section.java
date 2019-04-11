package transport.section;

import place.Place;

public abstract class Section {

    protected int nbPlaces;
    private float ratio;
    protected Place[] places;
    private String str;

    public Section(int nbPlaces, float ratio, String str) {
        this.nbPlaces = nbPlaces;
        this.ratio = ratio;
        this.places = new Place[nbPlaces];
        this.str = str;
    }

    protected abstract void initPlaces();

    public String getStr() {
        return str;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public int getNbPlacesReserved() {
        return getNbPlaces() - getNbPlacesDispo();
    }

    public float calculPrice(int price) {
        return ((price * ratio) / 100);
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
