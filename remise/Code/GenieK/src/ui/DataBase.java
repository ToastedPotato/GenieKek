package ui;

import com.sun.org.apache.xpath.internal.operations.Or;
import company.Company;
import company.CruiseCompany;
import company.FlightCompany;
import company.TrainCompany;
import exception.TripException;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import reservation.Reservation;
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
        addStation(PortFactory.getInstance().createStation("ALE", "Alger"));

        Company c;
        // compagnie de train
        c = TrainCompanyFactory.getInstance().createCompany("STMGRP","STM Groupe", 400);
        // trains
        c.getTransports().add(c.createTransport("PIO")
                .addSection(new OrganizableSection(OrganizableSection.Type.PREMIERE, Disposition.MEDIUM, 500)));
        c.getTransports().add(c.createTransport("MRP")
                .addSection(new OrganizableSection(OrganizableSection.Type.PREMIERE, Disposition.MEDIUM, 300))
                .addSection(new OrganizableSection(OrganizableSection.Type.BUSINESS, Disposition.COMFORT, 200)));
        // trajets
        c.getTrips().add(c.createTrip("PZ", 1, getStation("GDN"), getStation("AGD"), "2019.04.25 10:20", "2019.04.25 15:23", "PIO")
                .addStop(getStation("UID"))
                .addStop(getStation("POZ")));
        c.getTrips().add(c.createTrip("PL", 56, getStation("POZ"), getStation("UID"), "2019.04.26 09:40", "2019.04.26 12:19", "MRP")
                .addStop(getStation("GDN")));
        c.getTrips().add(c.createTrip("PL", 57, getStation("POZ"), getStation("UID"), "2019.04.27 09:40", "2019.04.27 11:45", "MRP"));
        addCompany(c);

        // compagnie aérienne
        c = FlightCompanyFactory.getInstance().createCompany("AIRCAN", "Air Canada", 800);
        // avions
        c.getTransports().add(c.createTransport("A45")
                .addSection(new OrganizableSection(OrganizableSection.Type.ECONOMIC, Disposition.LARGE, 100)));
        c.getTransports().add(c.createTransport("A48")
                .addSection(new OrganizableSection(OrganizableSection.Type.ECONOMIC, Disposition.LARGE, 140))
                .addSection(new OrganizableSection(OrganizableSection.Type.BUSINESS, Disposition.MEDIUM, 60)));
        // vols
        c.getTrips().add(c.createTrip("PT", 1, getStation("CDG"), getStation("YUL"), "2019.04.23 09:10", "2019.04.23 16:50", "A45"));
        c.getTrips().add(c.createTrip("KO", 4, getStation("CDG"), getStation("YUL"), "2019.04.24 10:50", "2019.04.24 18:24", "A48"));
        c.getTrips().add(c.createTrip("KI", 67, getStation("YUL"), getStation("JFK"), "2019.04.25 16:30", "2019.04.25 18:38", "A48"));
        addCompany(c);

        // compagnie de croisière
        c = CruiseCompanyFactory.getInstance().createCompany("COSTAC", "Costa Croisière", 2000);
        // paquebots
        c.getTransports().add(c.createTransport("PQ4")
                .addSection(new CabinSection(CabinSection.Type.OCEAN, 80))
                .addSection(new CabinSection(CabinSection.Type.INTERIOR, 100))
                .addSection(new CabinSection(CabinSection.Type.DELUXE, 50))
                .addSection(new CabinSection(CabinSection.Type.FAMILY, 50))
                .addSection(new CabinSection(CabinSection.Type.SUITE, 30)));
        c.getTransports().add(c.createTransport("FO3")
                .addSection(new CabinSection(CabinSection.Type.OCEAN, 100))
                .addSection(new CabinSection(CabinSection.Type.INTERIOR, 150))
                .addSection(new CabinSection(CabinSection.Type.DELUXE, 60))
                .addSection(new CabinSection(CabinSection.Type.FAMILY, 80))
                .addSection(new CabinSection(CabinSection.Type.SUITE, 45)));
        // itinéraires
        c.getTrips().add(c.createTrip("MA", 1, getStation("MSR"), getStation("MSR"), "2019.04.29 11:45", "2019.05.12 16:20", "PQ4")
                .addStop(getStation("ALE"))
                .addStop(getStation("TUN"))
                .addStop(getStation("EGY")));
        c.getTrips().add(c.createTrip("AE", 1, getStation("ALE"), getStation("ALE"), "2019.05.15 08:55", "2019.06.24 14:30", "FO3")
                .addStop(getStation("EGY"))
                .addStop(getStation("TUN")));
        c.getTrips().add(c.createTrip("AT", 1, getStation("MSR"), getStation("MSR"), "2019.05.29 11:45", "2019.06.12 16:20", "PQ4")
                .addStop(getStation("ALE"))
                .addStop(getStation("TUN"))
                .addStop(getStation("EGY")));
        addCompany(c);
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

    public Station getStation(String stationId) {
        for (Station station : stations)
            if (station.getId().equals(stationId)) return station;
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

    public boolean transportExist(String transportId) {
        return getTransport(transportId) != null;
    }

    public boolean tripExist(String tripId) {
        return getTrip(tripId) != null;
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
        if (numResa.length() <= 6) return null;
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
        String string = "";
        for (Company company : companies)
            string += visitor.visit(company) + "\n";
        return string;
    }

}
