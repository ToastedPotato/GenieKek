package factory.company;

import company.Company;

public abstract class CompanyFactory {

    protected abstract Company fabricateCompany();

    public Company createCompany(String id, String name){

        Company c = fabricateCompany();
        c.setId(id);
        c.setName(name);

        return c;
    }



}
