package trip;

import station.Station;

import java.util.List;

public class Trip{

    private String id;
    private int number;
    private Station depart;
    private Station arrive;
    private String idCompany;
    private List<Schedule> schedules;

    public Trip() {

    }

    public Trip(String id, int number, Station depart, Station arrive, String idCompany) {
        this.id = id;
        this.number = number;
        this.depart = depart;
        this.arrive = arrive;
        this.idCompany = idCompany;
    }

    public void addSchedules(Schedule s){

        schedules.add(s);

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStation(Station depart,Station arrive) throws CruiseException {
        this.depart = depart;
        this.arrive = arrive;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}