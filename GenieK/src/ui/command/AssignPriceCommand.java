package ui.command;

public class AssignPriceCommand extends ModifyCommand{

    Company target;
    
    int oldPrice;
    
    int newPrice;
    
    public AssignPriceCommand(Company target, int oldprice, int newPrice){
        this.target = target;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;        
    }
    
    public void execute(){
        this.target.setPrice(this.newPrice);
    }
    
    public void undo(){
        this.target.setPrice(this.oldPrice);
    }    
}
