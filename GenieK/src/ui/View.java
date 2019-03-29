package ui;

import java.util.*;

public class View{

    private String output = "";
    
    public View(){
        return;
    }
    
    public void update(String message){
        this.output = message;
    }
    
    public void display(){
    
        System.out.println(this.output);
    }

}
