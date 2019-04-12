package trip;

import station.Station;
import transport.Transport;
import transport.section.Section;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Trip{

    private String id;
    private int number;
    private Station depart, arrive;
    private String idCompany;
    private Transport transport;
    private Date departureDate, arrivedDate;
    private ArrayList<Station> stops = new ArrayList<>();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm");


    public Trip() {

    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public int getNumber() {
        return this.number;
    }    
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public Station getDepart(){
        return this.depart;
    }
    
    public Station getArrive(){
        return this.arrive;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setStation(Station depart, Station arrive) {
        this.depart = depart;
        this.arrive = arrive;
    }

    public String getIdCompany() {
        return this.idCompany;
    }    

    public ArrayList<Section> getSections() {
        return transport.getSections();
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public String getDepartureDateToString() {
        return format.format(departureDate);
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivedDate() {
        return arrivedDate;
    }

    public String getArrivedDateToString() {
        return format.format(arrivedDate);
    }

    public void setArrivalDate(Date arrivedDate) {
        this.arrivedDate = arrivedDate;
    }

    public void setDepartureDate(String departureDate) {
        try {
            this.departureDate = format.parse(departureDate);
        } catch (ParseException ignored) { }
    }

    public void setArrivalDate(String arrivedDate) {
        try {
            this.arrivedDate = format.parse(arrivedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public boolean haveStop(Station stop) {
        for (Station station : stops)
            if (station.getId().equals(stop.getId())) return true;
        return false;
    }

    public Trip addStop(Station stop) {
        // si l'élément existe déjà on sort
        if (stops.indexOf(stop) >= 0) return this;
        stops.add(stop);
        return this;
    }
}
