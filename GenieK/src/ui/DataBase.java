package ui;

import company.Company;
import exception.NullObjectException;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.OrganizableSection;
import transport.section.Disposition;
import trip.Trip;
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
        c.getTransports().add(c.createTransport("PIO")
                .addSection(new OrganizableSection(OrganizableSection.Type.PREMIERE, Disposition.MEDIUM, 30)));
        c.getTrips().add(c.createTrip("PZ", 1, getStation("GDN"), getStation("AGD"), "PIO")
                .addStop(getStation("UID"))
                .addStop(getStation("POZ")));
        addCompany(c);

        c = FlightCompanyFactory.getInstance().createCompany("ARC", "Air Canada", 800);
        c.getTransports().add(c.createTransport("A45")
                .addSection(new OrganizableSection(OrganizableSection.Type.ECONOMIC, Disposition.LARGE, 100)));
        c.getTrips().add(c.createTrip("PT", 1, getStation("CDG"), getStation("YUL"), "A45"));
        addCompany(c);

        c = CruiseCompanyFactory.getInstance().createCompany("COS", "Costa Croisière", 2000);
        c.getTransports().add(c.createTransport("PQ4")
                .addSection(new CabinSection(CabinSection.Type.OCEAN, 10)));
        c.getTrips().add(c.createTrip("ME", 1, getStation("MSR"), getStation("MSR"), "PQ4")
                .addStop(getStation("ALE"))
                .addStop(getStation("TUN"))
                .addStop(getStation("EGY")));
        addCompany(c);
    }

    public Transport getTransport(String transportId) {
        Transport transport;
        for (Company company : companies) {
            transport = company.getTransport(transportId);
            if (transport != null) return transport;
        }
        return null;
    }

    public Trip getTrip(String tripId) {
        Trip trip;
        for (Company company : companies) {
            trip = company.getTrip(tripId);
            if (trip != null) return trip;
        }
        return null;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public Station getStation(String stationId) {
        for (Station station : stations) {
            if (station.getId().equals(stationId)) return station;
        }
        try {
            throw new NullObjectException(stationId);
        } catch (NullObjectException ignored) {}
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
        try {
            throw new NullObjectException(companyId);
        } catch (NullObjectException ignored) {}
        return null;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public boolean companyExist(String companyId) {
        return getCompany(companyId) != null;
    }

    public boolean stationExist(String stationId) {
        return getStation(stationId) != null;
    }

    

    public Company getCompanyByTrip(String tripId) {
        for (Company company : companies) {
            if (company.haveTrip(tripId)) return company;
        }
        return null;
    }

    public int getCompanyPrice(String companyId) {
        return getCompany(companyId).getPrice();
    }

    public String stationsToString(Visitor visitor){
        StringBuilder string = new StringBuilder();
        for (Station station : stations) {
            string.append(visitor.visit(station)).append("\n");
        }
        return string.toString();
    }

    public String companiesToString(Visitor visitor){
        StringBuilder string = new StringBuilder();
        for (Company company : companies) {
            string.append(visitor.visit(company)).append("\n");
        }
        return string.toString();
    }

}
