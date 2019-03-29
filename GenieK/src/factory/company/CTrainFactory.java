package factory.company;

import company.*;
import factory.transport.TrainFactory;

public class CTrainFactory extends CompanyFactory {

    private static CTrainFactory instance = null;

    private CTrainFactory() {

    }

    public static CompanyFactory getInstance() {
        if (instance == null) instance = new CTrainFactory();
        return instance;
    }

    @Override
    protected Company fabricateCompany() {
        CTrain c = new CTrain();
        c.setTransportFactory(TrainFactory.getInstance());
        return c;
    }
}
