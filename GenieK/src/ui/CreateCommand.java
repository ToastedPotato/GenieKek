public abstract class CreateCommand extends Command{
    
    T target; //l'objet auquel l'instance créée doit être rattachée
    
    T instance; //la nouvelle instance
    
    public void execute(){}
    
    public void undo(){}
}
