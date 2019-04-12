package ui;

import company.Company;
import company.CruiseCompany;
import company.FlightCompany;
import company.TrainCompany;
import exception.NullObjectException;
import exception.TripException;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import reservation.Reservation;
import station.*;
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

    /**
     * Initialise la base de données
     */
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
        c = TrainCompanyFactory.getInstance().createCompany("STMGRP","STM Groupe", 400);
        c.getTransports().add(c.createTransport("PIO")
                .addSection(new OrganizableSection(OrganizableSection.Type.PREMIERE, Disposition.MEDIUM, 30)));
        c.getTrips().add(c.createTrip("PZ", 1, getStation("GDN"), getStation("AGD"), "2019.04.26 12:28", "2019.04.26 17:23", "PIO")
                .addStop(getStation("UID"))
                .addStop(getStation("POZ")));
        addCompany(c);

        c = FlightCompanyFactory.getInstance().createCompany("AIRCAN", "Air Canada", 800);
        c.getTransports().add(c.createTransport("A45")
                .addSection(new OrganizableSection(OrganizableSection.Type.ECONOMIC, Disposition.LARGE, 100)));
        c.getTrips().add(c.createTrip("PT", 1, getStation("CDG"), getStation("YUL"), "2019.04.23 09:10", "2019.04.23 16:50", "A45"));
        addCompany(c);

        c = CruiseCompanyFactory.getInstance().createCompany("COSTAC", "Costa Croisière", 2000);
        c.getTransports().add(c.createTransport("PQ4")
                .addSection(new CabinSection(CabinSection.Type.OCEAN, 10)));
        c.getTrips().add(c.createTrip("ME", 1, getStation("MSR"), getStation("MSR"), "2019.04.29 11:45", "2019.05.12 16:20", "PQ4")
                .addStop(getStation("ALE"))
                .addStop(getStation("TUN"))
                .addStop(getStation("EGY")));
        addCompany(c);
        View.CONSOLE_ENABLE = true;
    }

    /**
     * Retourne le transport correspondant
     * Exception si le transport n'existe pas
     * @param transportId : id du transport
     * @return
     */
    public Transport getTransport(String transportId) {
        Transport transport;
        for (Company company : companies) {
            transport = company.getTransport(transportId);
            if (transport != null) return transport;
        }
        return null;
    }

    /**
     * Retourne le voyage correspondant
     * Exception si le voyage n'existe pas
     * @param tripId
     * @return
     */
    public Trip getTrip(String tripId) {
        Trip trip;
        for (Company company : companies) {
            trip = company.getTrip(tripId);
            if (trip != null) return trip;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Station> getStations() {
        return stations;
    }

    public ArrayList<Aeroport> getAeroport(String city) {

        ArrayList<Aeroport> aeroports = new ArrayList<>();

        for (Station s:stations) {

            if(s.getCity().equals(city) && s instanceof Aeroport) aeroports.add((Aeroport)s);

        }

        return aeroports;

    }

    public ArrayList<Port> getHarbor(String city) {

        ArrayList<Port> ports = new ArrayList<>();

        for (Station s:stations) {

            if(s.getCity().equals(city) && s instanceof Port) ports.add((Port)s);

        }

        return ports;

    }

    public ArrayList<Railway> getRailway(String city) {

        ArrayList<Railway> railways = new ArrayList<>();

        for (Station s:stations) {

            if(s.getCity().equals(city) && s instanceof Railway) railways.add((Railway) s);

        }

        return railways;

    }

    public Station getStation(String stationId) {
        for (Station station : stations)
            if (station.getId().equals(stationId)) return station;
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

    public ArrayList<Company> getFlightCompany() {

        ArrayList<Company> companieslist = new ArrayList<>();

        for (Company c:companies) {

            if(c instanceof FlightCompany) companieslist.add((FlightCompany)c);

        }

        return companieslist;
    }

    public ArrayList<Company> getCruiseCompany() {

        ArrayList<Company> companieslist = new ArrayList<>();

        for (Company c:companies) {

            if(c instanceof CruiseCompany) companieslist.add((CruiseCompany)c);

        }

        return companieslist;
    }

    public ArrayList<Company> getTrainCompany() {

        ArrayList<Company> companieslist = new ArrayList<>();

        for (Company c:companies) {

            if(c instanceof TrainCompany) companieslist.add((TrainCompany)c);

        }

        return companieslist;
    }

    public Company getCompany(String companyId) {
        for (Company company : companies)
            if (company.getId().equals(companyId)) return company;
        try {
            throw new NullObjectException(companyId);
        } catch (NullObjectException ignored) {}
        return null;
    }

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public boolean companyExist(String companyId) {
        for (Company company : companies)
            if (company.getId().equals(companyId)) return true;
        return false;
    }

    public boolean stationExist(String stationId) {
        for (Station station : stations)
            if (station.getId().equals(stationId)) return true;
        return false;
    }

    public boolean transportExist(String transportId) {
        Transport transport;
        for (Company company : companies) {
            transport = company.getTransport(transportId);
            if (transport != null) return true;
        }
        return false;
    }

    public boolean tripExist(String tripId) {
        Trip trip;
        for (Company company : companies) {
            trip = company.getTrip(tripId);
            if (trip != null) return true;
        }
        return false;
    }

    public Company getCompanyByTrip(String tripId) {
        for (Company company : companies) {
            if (company.haveTrip(tripId)) return company;
        }
        try {
            throw new TripException(tripId);
        } catch (TripException ignored) { }
        return null;
    }

    public Reservation getReservation(String numResa) {
        if (numResa.length() != 6) return null;
        Company company = getCompany(numResa.substring(0, 6));
        if (company == null) return null;
        return company.getReservation(numResa);
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
