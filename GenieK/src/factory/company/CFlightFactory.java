package factory.company;

import company.*;
import factory.transport.PlaneFactory;


public class CFlightFactory extends CompanyFactory {

    private static CFlightFactory instance = null;

    private CFlightFactory() {

    }

    public static CompanyFactory getInstance() {
        if (instance == null) instance = new CFlightFactory();
        return instance;
    }

    protected Company fabricateCompany(){
        CFlight c = new CFlight();
        c.setTransportFactory(PlaneFactory.getInstance());
        return c;
    }
}
