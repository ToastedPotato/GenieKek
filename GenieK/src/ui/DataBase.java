package ui;

import company.Company;
import station.Station;
import visitor.Visitor;

import java.util.ArrayList;

public class DataBase {

    private static DataBase instance = null;

    private ArrayList<Station> stations = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();

    public static DataBase getInstance(){
        if(instance == null) instance = new DataBase();
        return instance;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public String stationsToString(Visitor visitor){

        String string = "";

        for (Station s:stations) {

            string += visitor.visit(s) + "\n";

        }

        return  string;

    }

    public String companiesToString(Visitor visitor){

        String string = "";

        for (Company c:companies) {

            string += visitor.visit(c) + "\n";

        }

        return string;

    }
}
