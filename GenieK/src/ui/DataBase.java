package ui;

import company.Company;
import station.Station;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase instance = null;

    private List<Station> stations = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public static DataBase getInstance(){
        if(instance == null) instance = new DataBase();
        return instance;
    }
}
