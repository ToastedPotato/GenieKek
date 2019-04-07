package ui.command;

import company.Company;

public class ModifyCompanyCommand implements Command{

    private Company company;
    private int oldPrice = -1, newPrice = -1;
    private String oldName, newName, oldId, newId;

    public ModifyCompanyCommand(Company company, int newPrice, String newName, String newId) {
        this.company = company;
        this.newPrice = newPrice;
        this.newName = newName;
        this.newId = newId;
    }

    public ModifyCompanyCommand(Company company, String newName, String newId) {
        this.company = company;
        this.oldName = company.getName();
        this.newName = newName;
        this.oldId = company.getId();
        this.newId = newId;
    }

    public ModifyCompanyCommand(Company company, int newPrice){
        this.company = company;
        this.oldPrice = company.getPrice();
        this.newPrice = newPrice;        
    }

    @Override
    public void execute(){
        if (newPrice > 0) this.company.setPrice(this.newPrice);
        if (newId != null) this.company.setId(this.newId);
        if (newName != null) this.company.setName(this.newName);
    }

    @Override
    public void unexecute(){
        if (oldPrice > 0) this.company.setPrice(this.oldPrice);
        if (oldId != null) this.company.setId(this.oldId);
        if (oldName != null) this.company.setName(this.oldName);
    }    
}
