public abstract class DeleteCommand extends Command{

    T target;   //l'objet duquel il faut retirer l'instance
    
    T deletedInstance; //l'instance à retirer de l'objet
    
    public void execute(){}
    
    public void undo(){}
}
