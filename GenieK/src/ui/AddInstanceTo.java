public class AddInstanceTo<T> extends Command{
    
    T target; //l'objet auquel l'instance créée doit être rattachée
    
    Object instance; //la nouvelle instance
    
    public AddInstanceTo<T>(T target, Object instance){
        this.target = target;
        this.instance = instance;
    }
    
    public void execute(){
        target.add(this.instance);
    }
    
    public void undo(){
        target.remove(this.instance);
    }
}



