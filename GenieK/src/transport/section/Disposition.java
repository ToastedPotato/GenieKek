package transport.section;

import exception.EnumException;
import visitor.Visitor;

public enum Disposition {
    SMALL (3, "1-2"),
    COMFORT (4, "2-3"),
    MEDIUM (6, "3-4"),
    LARGE (10, "3-4, 7-8")
    ;

    private final int column;
    private final String lanes;

    Disposition(int column, String lanes) {
        this.column = column;
        this.lanes = lanes;
    }

    public static Disposition get(String str) {
        for (Disposition dispo : Disposition.values()) {
            if (str.equals(dispo.getStr())) return dispo;
        }
        try {
            throw new EnumException(str);
        } catch (EnumException ignored) { }
        return null;
    }

    public String getStr() {
        return String.valueOf(this.toString().charAt(0));
    }

    public String getLanes() {
        return lanes;
    }

    public int getNbColumn() {
        return column;
    }

    public String print(Visitor visitor) {
        return visitor.visit(this);
    }


}
