package transport.section;

import exception.EnumException;
import place.Column;
import place.Seat;

public class OrganizableSection extends Section {

    public enum Type {
        PREMIERE ("F",100),
        BUSINESS ("A", 75),
        PREMIUM ("P", 60),
        ECONOMIC ("E",50)
        ;

        private final String str;
        private final int ratio;

        Type (String str, int ratio) {
            this.str = str;
            this.ratio = ratio;
        }

        public static Type get(String str) {
            for (Type type : Type.values()) {
                if (type.str.equals(str)) return type;
            }
            try {
                throw new EnumException(str);
            } catch (EnumException ignored) { }
            return null;
        }

        public String getStr() {
            return str;
        }

        public int getRatio() {
            return ratio;
        }
    }

    private Disposition disposition;
    private int nbRow;

    public OrganizableSection(Type type, Disposition disposition, int nbSeat) {
        super(nbSeat, type.ratio, type.str);
        this.disposition = disposition;
        // calcul le nombre de rangée nécessaire par rapport à la disposition
        this.nbRow = nbSeat / getNbColumn();
        initPlaces();
    }

    @Override
    protected void initPlaces() {
        // place les sièges colonne par colonne puis une fois
        // arrivé au bout on passe à la rangée suivante
        int row = 0, colum = 0;
        for (int i = 0; i < nbPlaces; i++) {
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
