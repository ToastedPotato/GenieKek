package ui;

public class View {

    private String output = "";
    
    void update(String message){
        this.output = message;
    }
    
    void display(){
        System.out.println(this.output);
    }

}
