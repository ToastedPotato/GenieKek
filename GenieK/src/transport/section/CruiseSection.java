package transport.section;

import place.Cabin;

public class CruiseSection extends Section {

    public CruiseSection(int nbCabin, float ratio, int capacity) {
        super(nbCabin, ratio);
        for (int i = 0; i < nbCabin; i++) places[i] = new Cabin(capacity);
    }
}
