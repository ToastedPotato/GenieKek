package ui.command;

import java.util.ArrayList;

public class DeleteInstanceFrom<T> implements Command{

    private ArrayList<T> target; //l'objet auquel l'instance créée doit être rattachée
    private T instance; //la nouvelle instance

    public DeleteInstanceFrom(ArrayList<T> target, T instance){
        this.target = target;
        this.instance = instance;
    }

    public boolean execute(){
        return target.remove(this.instance);
    }

    public boolean unexecute(){
        return target.add(this.instance);
    }
}
