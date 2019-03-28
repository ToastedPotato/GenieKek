package ui

public class View{

    private string output;
    
    public void update(string message){
        this.output = message;
    }
    
    public void display(){
    
        System.out.println(this.output);
    }

}
