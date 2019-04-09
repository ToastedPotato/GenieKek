package ui;

import company.Company;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import station.Station;
import transport.section.FSection;
import transport.section.OSection;
import transport.section.disposition.Comfort;
import transport.section.disposition.Large;
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

    public void init() {
        addStation(RailwayFactory.getInstance().createStation("GDN", "Montréal"));
        addStation(RailwayFactory.getInstance().createStation("AGD", "Laval"));
        addStation(RailwayFactory.getInstance().createStation("UID", "Québec"));
        addStation(RailwayFactory.getInstance().createStation("POZ", "Toronto"));

        addStation(AeroportFactory.getInstance().createStation("CDG", "Paris"));
        addStation(AeroportFactory.getInstance().createStation("YUL", "Montréal"));
        addStation(AeroportFactory.getInstance().createStation("JFK", "New-York"));
        addStation(AeroportFactory.getInstance().createStation("LIM", "Lima"));

        addStation(PortFactory.getInstance().createStation("MSR", "Marseille"));
        addStation(PortFactory.getInstance().createStation("TUN", "Tunis"));
        addStation(PortFactory.getInstance().createStation("EGY", "Le Caire"));
        addStation(PortFactory.getInstance().createStation("ALE", "Alge"));

        Company c;
        c = TrainCompanyFactory.getInstance().createCompany("STM","STM Groupe", 400);
        c.createTransport("PIO")
                .addSection(new FSection(30, new Comfort()));
        c.createTrip("PZA", 1, getStation("GDN"), getStation("AGD"), "PIO")
                .addStop(getStation("UID"))
                .addStop(getStation("POZ"));
        addCompany(c);

        c = FlightCompanyFactory.getInstance().createCompany("ARC", "Air Canada", 800);
        c.createTransport("A45")
                .addSection(new FSection(60, new Large()));
        c.createTrip("PTM", 1, getStation("CGD"), getStation("YUL"), "A45");
        addCompany(c);

        c = CruiseCompanyFactory.getInstance().createCompany("COS", "Costa Croisière", 2000);
        c.createTransport("PQ4")
                .addSection(new OSection(70));
        c.createTrip("MED", 1, getStation("MSR"), getStation("MSR"), "PQ4")
                .addStop(getStation("ALE"))
                .addStop(getStation("TUN"))
                .addStop(getStation("EGY"));
        addCompany(c);

    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public Station getStation(String stationId) {
        for (Station station : stations) {
            if (station.getId().equals(stationId)) return station;
        }
        return null;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public Company getCompany(String companyId) {
        for (Company company : companies) {
            if (company.getId().equals(companyId)) return company;
        }
        return null;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public Company getCompanyByTrip(String tripId) {
        for (Company company : companies) {
            if (company.haveTrip(tripId)) return company;
        }
        return null;
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
