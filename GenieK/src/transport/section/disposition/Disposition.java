package transport.section.disposition;

public class Disposition {

    private int nbColumn;
    private String lanes;

    public Disposition(int nbColumn, String lanes) {
        this.nbColumn = nbColumn;
        this.lanes = lanes;
    }

    public int getNbColumn() {
        return nbColumn;
    }

    public String getLanes() {
        return "Aile(s) entre les rangées " + lanes;
    }
}
