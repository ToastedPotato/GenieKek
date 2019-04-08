package ui;

import ui.menu.Menu;
import visitor.Visitor;

public abstract class Control{
    
    protected View view;
    
    protected Menu mainMenu;

    protected Visitor visitor;
    
    public void listen(){
    
    }

}
