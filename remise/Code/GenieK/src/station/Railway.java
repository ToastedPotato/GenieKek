package station;

public class Railway extends Station {

    private int nbQuai;

    /*public Railway(String id, String city, int nbQuai) {
        super(id, city);
        this.nbQuai = nbQuai;
    }*/

    public void setNbQuai(int nbQuai) {
        this.nbQuai = nbQuai;
    }

    public int getNbQuai() {
        return nbQuai;
    }
}
