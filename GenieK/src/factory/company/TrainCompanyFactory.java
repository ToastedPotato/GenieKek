package factory.company;

import company.*;
import factory.transport.TrainFactory;
import factory.trip.LineFactory;
import transport.Train;

public class TrainCompanyFactory extends CompanyFactory {

    private static TrainCompanyFactory instance = null;

    public static TrainCompanyFactory getInstance() {
        if (instance == null) instance = new TrainCompanyFactory();
        return instance;
    }

    /*@Override
    public TrainCompany createCompany(String id, String name, int price) {
        return (TrainCompany) super.createCompany(id, name, price);
    }*/

    @Override
    protected Company fabricateCompany() {
        TrainCompany c = new TrainCompany();
        c.setTransportFactory(TrainFactory.getInstance());
        c.setTripFactory(LineFactory.getInstance());
        return c;
    }
}
