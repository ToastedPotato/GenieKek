public class AddInstanceTo<T> extends Command{
    
    T target; //l'objet auquel l'instance créée doit être rattachée
    
    Object instance; //la nouvelle instance
    
    public CreateCommand<T>(T target){
        this.target = target;
    }
    
    public void execute(){
        target.add(instance);
    }
    
    public void undo(){
        target.remove(instance);
    }
}



