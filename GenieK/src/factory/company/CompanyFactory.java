package factory.company;

import company.Company;
import exception.ExistException;
import exception.IdException;
import exception.PriceException;
import ui.DataBase;

public abstract class CompanyFactory {

    protected abstract Company fabricateCompany();

    public Company createCompany(String id, String name, int price) {
        if (id.length() != 6) {
            try {
                throw new IdException(id);
            } catch (IdException ignored) { }
        }
        if (price <= 0) {
            try {
                throw new PriceException();
            } catch (PriceException ignored) { }
        }
        if (DataBase.getInstance().companyExist(id)) {
            try {
                throw new ExistException(id);
            } catch (ExistException ignored) { }
            return null;
        }
        Company c = fabricateCompany();
        c.setId(id);
        c.setName(name);
        c.setPrice(price);
        return c;
    }
}
