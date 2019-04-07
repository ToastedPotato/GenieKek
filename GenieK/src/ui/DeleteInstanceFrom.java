public class DeleteInstanceFrom<T> extends Command{

    T target;   //l'objet duquel il faut retirer l'instance
    
    Object instance; //l'instance à retirer de l'objet
    
    public DeleteInstanceFrom<T>(T target, Object instance){
        this.target = target;
        this.instance = instance;
    }    
    
    public void execute(){
        target.remove(this.instance);
    }
    
    public void undo(){
        target.add(this.instance);
    }
}
