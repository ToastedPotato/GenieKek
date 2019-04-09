import company.Company;
import company.TrainCompany;
import factory.company.TrainCompanyFactory;
import factory.station.RailwayFactory;
import factory.station.StationFactory;
import station.Railway;
import station.Station;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello there !");
        Company c = TrainCompanyFactory.getInstance().createCompany("caca","prout", 400);

        c.createTransport("casqddqsd");
        c.createTrip("PZA", 1, RailwayFactory.getInstance().createStation("GDN", "Paris"), new Station("ASL", "Toulouse"))
                .addStop(new Station("MCL", "Poitiers"))
                .addStop(new Station("DVS", "Bordeaux"))
                .addStop(new Station("LMG", "Limoges"));

        System.out.println(c);
    }

}
