package factory.company;

import company.Company;
import exception.IdException;
import exception.PriceException;

public abstract class CompanyFactory {

    protected abstract Company fabricateCompany();

    public Company createCompany(String id, String name, int price) {
        if (id.length() != 3) {
            try {
                throw new IdException(id);
            } catch (IdException ignored) { }
        }
        if (price <= 0) {
            try {
                throw new PriceException();
            } catch (PriceException ignored) { }
        }
        Company c = fabricateCompany();
        c.setId(id);
        c.setName(name);
        c.setPrice(price);
        return c;
    }



}
