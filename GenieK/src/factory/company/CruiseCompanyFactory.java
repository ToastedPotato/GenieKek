package factory.company;

import company.*;
import factory.transport.*;
import factory.trip.CruiseFactory;

public class CruiseCompanyFactory extends CompanyFactory {

    private static CruiseCompanyFactory instance = null;

    public static CompanyFactory getInstance() {
        if (instance == null) instance = new CruiseCompanyFactory();
        return instance;
    }

    @Override
    protected Company fabricateCompany() {
        CruiseCompany c = new CruiseCompany();
        c.setTransportFactory(BoatFactory.getInstance());
        c.setTripFactory(CruiseFactory.getInstance());
        return c;
    }
}
