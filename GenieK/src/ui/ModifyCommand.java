public abstract class ModifyCommand extends Command{

    T target;   //l'objet dont il faut modifier les attributs
    
    T oldAttributeValue; //ancienne valeur de l'attribut à modifier
    
    T newAttributeValue; //la nouvelle valeur de l'attribut
    
    public void execute(){}
    
    public void undo(){}
}
