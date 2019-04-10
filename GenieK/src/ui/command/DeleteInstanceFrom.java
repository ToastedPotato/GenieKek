package ui.command;

import java.util.ArrayList;

public class DeleteInstanceFrom<T> implements Command{

    private ArrayList<T> target; //l'objet auquel l'instance créée doit être rattachée
    private T instance; //la nouvelle instance

    public DeleteInstanceFrom(ArrayList<T> target, T instance){
        this.target = target;
        this.instance = instance;
    }

    public void execute(){
        target.remove(this.instance);
    }

    public void unexecute(){
        target.add(this.instance);
    }
}
