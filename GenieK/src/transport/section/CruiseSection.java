package transport.section;

import place.Cabin;

public class CruiseSection extends Section {

    private int capacity;

    public CruiseSection(int nbCabin, float ratio, int capacity) {
        super(nbCabin, ratio);
        this.capacity = capacity;
        initPlaces();
    }

    @Override
    protected void initPlaces() {
        for (int i = 0; i < nbPlaces; i++)
            places[i] = new Cabin(capacity);
    }
}
