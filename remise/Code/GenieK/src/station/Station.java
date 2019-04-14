package station;

public class Station {

    protected String id, city;

    public Station() {
    }

    public Station(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity(){
        return this.city;
    }
}
