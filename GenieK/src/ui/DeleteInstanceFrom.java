public abstract class DeleteInstanceFrom<T> extends Command{

    T target;   //l'objet duquel il faut retirer l'instance
    
    Object Instance; //l'instance à retirer de l'objet
    
    public void execute(){}
    
    public void undo(){}
}
