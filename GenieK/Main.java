import company.Company;
import factory.company.CTrainFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello there !");
        Company c = CTrainFactory.getInstance().createCompany("caca","prout");

        c.createTransport("casqddqsd");
    }

}
