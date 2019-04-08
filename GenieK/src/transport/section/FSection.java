package transport.section;

import transport.section.disposition.Disposition;

public class FSection extends GenericSection {

    public FSection(int nbSeat, Disposition disposition) {
        super(nbSeat, 70, disposition);
    }
}
