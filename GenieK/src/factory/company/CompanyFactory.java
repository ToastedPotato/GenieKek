package factory.company;

import company.Company;

public abstract class CompanyFactory {

    protected abstract Company fabricateCompany();

    public Company createCompany(String id, String name, int price) {
        Company c = fabricateCompany();
        c.setId(id);
        c.setName(name);
        c.setPrice(price);
        return c;
    }



}
