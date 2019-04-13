package place;

public class Cabin extends Place{

    // nombre de client pouvant dormir dans la cabine
    private int capacity;

    public Cabin(int capacity) {
        super(72);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
