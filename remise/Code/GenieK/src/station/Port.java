package station;

public class Port extends Station {

    private int nbPonton;

    /*public Port(String id, String city, int nbPonton) {
        super(id, city);
        this.nbPonton = nbPonton;
    }*/

    public void setNbPonton(int nbPonton) {
        this.nbPonton = nbPonton;
    }

    public int getNbPonton() {
        return nbPonton;
    }
}
