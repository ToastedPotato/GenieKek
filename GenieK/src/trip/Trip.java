package trip;

import station.Station;
import transport.Transport;
import transport.section.Section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trip{

    private String id;
    private int number;
    private Station depart, arrive;
    private String idCompany;
    private Transport transport;
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private ArrayList<Station> stops = new ArrayList<>();

    public Trip() {

    }

    public void addSchedules(Schedule s){
        schedules.add(s);
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

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public Trip addStop(Station stop) {
        // si l'élément existe déjà on sort
        if (stops.indexOf(stop) >= 0) return this;
        stops.add(stop);
        return this;
    }
}
