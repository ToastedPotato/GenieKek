package ui.command;

import java.util.ArrayList;

public class AddInstanceTo implements Command{
    
    private ArrayList<Object> target; //l'objet auquel l'instance créée doit être rattachée
    private Object instance; //la nouvelle instance
    
    public AddInstanceTo(ArrayList<Object> target, Object instance){
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



