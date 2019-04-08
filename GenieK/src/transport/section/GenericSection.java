package transport.section;

import place.Column;
import place.Seat;
import transport.section.disposition.Disposition;

public class GenericSection extends Section {

    private Disposition disposition;
    private int nbRow;

    public GenericSection(int nbSeat, float ratio, Disposition disposition) {
        super(nbSeat, ratio);
        this.disposition = disposition;
        // calcul le nombre de rangée nécessaire par rapport à la disposition
        this.nbRow = nbSeat / getNbColumn();
        // place les sièges colonne par colonne puis une fois
        // arrivé au bout on passe à la rangée suivante
        int row = 0, colum = 0;
        for (int i = 0; i < nbSeat; i++) {
            places[i] = new Seat(row, Column.values()[colum]);
            colum++;
            // si on arrive à la dernière colonne de la disposition on passe à la prochaine rangée
            if (colum >= getNbColumn()) {
                colum = 0;
                row++;
            }
        }
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public int getNbColumn() {
        return disposition.getNbColumn();
    }

    public String getLanes() {
        return disposition.getLanes();
    }

    public int getNbRow() {
        return nbRow;
    }
}
