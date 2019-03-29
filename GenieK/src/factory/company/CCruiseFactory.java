package factory.company;

import company.*;
import factory.transport.*;

public class CCruiseFactory extends CompanyFactory {

    private static CCruiseFactory instance = null;

    private CCruiseFactory() {

    }

    public static CompanyFactory getInstance() {
        if (instance == null) instance = new CCruiseFactory();
        return instance;
    }

    @Override
    protected Company fabricateCompany() {
        CCruise c = new CCruise();
        c.setTransportFactory(BoatFactory.getInstance());
        return c;
    }
}
