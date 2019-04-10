package ui.command;

import company.Company;
import station.IdException;
import station.PriceException;

public class ModifyCompany implements Command{

    private Company company;
    private int oldPrice, newPrice;
    private String oldName, newName, oldId, newId;

    public ModifyCompany(Company company, String newId, String newName, int newPrice) {
        if (newId.length() != 3) {
            try {
                throw new IdException(newId);
            } catch (IdException ignored) { }
        }
        if (newPrice <= 0) {
            try {
                throw new PriceException();
            } catch (PriceException ignored) { }
        }
        this.company = company;
        this.newId = newId;
        this.newName = newName;
        this.newPrice = newPrice;
        this.oldPrice = company.getPrice();
        this.oldName = company.getName();
        this.oldId = company.getId();
    }

    @Override
    public void execute(){
        this.company.setPrice(this.newPrice);
        this.company.setId(this.newId);
        this.company.setName(this.newName);
    }

    @Override
    public void unexecute(){
        this.company.setPrice(this.oldPrice);
        this.company.setId(this.oldId);
        this.company.setName(this.oldName);
    }    
}
