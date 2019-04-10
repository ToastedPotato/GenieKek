package ui.command;

import java.util.ArrayList;

public class AddInstanceTo<T> implements Command{
    
    private ArrayList<T> target; //l'objet auquel l'instance créée doit être rattachée
    private T instance; //la nouvelle instance
    
    public AddInstanceTo(ArrayList<T> target, T instance){
        this.target = target;
        this.instance = instance;
    }
    
    public void execute(){
        target.add(this.instance);
    }
    
    public void unexecute(){
        target.remove(this.instance);
    }
}



