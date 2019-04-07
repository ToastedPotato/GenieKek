package ui.command;

public abstract class ModifyCommand implements Command{

    Object target;   //l'objet dont il faut modifier les attributs
    
    Object oldAttributeValue; //ancienne valeur de l'attribut à modifier
    
    Object newAttributeValue; //la nouvelle valeur de l'attribut
    
    public void execute(){}
    
    public void undo(){}
}
