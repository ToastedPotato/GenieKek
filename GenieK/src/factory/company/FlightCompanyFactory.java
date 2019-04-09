package factory.company;

import company.*;
import factory.transport.PlaneFactory;


public class FlightCompanyFactory extends CompanyFactory {

    private static FlightCompanyFactory instance = null;

    public static CompanyFactory getInstance() {
        if (instance == null) instance = new FlightCompanyFactory();
        return instance;
    }

    protected Company fabricateCompany(){
        FlightCompany c = new FlightCompany();
        c.setTransportFactory(PlaneFactory.getInstance());
        return c;
    }
}
