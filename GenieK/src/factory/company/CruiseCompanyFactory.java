package factory.company;

import company.*;
import factory.transport.*;

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
        return c;
    }
}
