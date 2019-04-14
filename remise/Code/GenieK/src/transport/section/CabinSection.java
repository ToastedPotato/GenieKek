package transport.section;

import exception.EnumException;
import place.Cabin;

public class CabinSection extends Section {

    public enum Type {
        INTERIOR ("I", 4, 50),
        OCEAN ("O", 2, 75),
        SUITE ("S", 5, 90),
        FAMILY ("F", 6, 90),
        DELUXE ("D", 6, 100)
        ;

        private final String str;
        private final int capacity, ratio;

        Type (String str, int capacity, int ratio) {
            this.str = str;
            this.capacity = capacity;
            this.ratio = ratio;
        }

        public static CabinSection.Type get(String str) {
            for (CabinSection.Type type : CabinSection.Type.values()) {
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

        public int getCapacity() {
            return capacity;
        }
    }

    private int capacity;

    public CabinSection(Type type, int nbCabin) {
        super(nbCabin, type.ratio, type.str);
        this.capacity = type.capacity;
        initPlaces();
    }

    @Override
    protected void initPlaces() {
        for (int i = 0; i < nbPlaces; i++)
            places[i] = new Cabin(capacity);
    }
}
