package trip;

import place.Place;
import station.Station;
import transport.Transport;
import transport.section.Section;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trip{

    private String id;
    private Station depart, arrive;
    private String companyId;
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
    
    public Station getDepart(){
        return this.depart;
    }
    
    public Station getArrive(){
        return this.arrive;
    }

    public Place pickFreePlace(String sectionId) {
        return getSection(sectionId).pickFreePlace();
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

    public String getCompanyId() {
        return this.companyId;
    }    

    public ArrayList<Section> getSections() {
        return transport.getSections();
    }

    public Section getSection(String sectionId) {
        for (Section section : getSections())
            if (section.getStr().equals(sectionId)) return section;
        return null;
    }

    public boolean haveSectionDispo(String str) {
        for (Section section : getSections())
            if (section.getStr().equals(str) && section.getNbPlacesDispo() > 0) return true;
        return false;
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

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
