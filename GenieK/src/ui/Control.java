package ui;

import ui.menu.Menu;
import visitor.Visitor;

import java.util.Scanner;

public abstract class Control {
    
    private View view;
    protected Menu mainMenu;
    protected Visitor visitor;
    protected DataBase dataBase;
    private Scanner scanner = new Scanner(System.in);
    
    public Control() {
        dataBase = DataBase.getInstance();
        view = new View();
    }

    protected void show() {
        initMenu();
        listen(mainMenu);
    }

    public void listen(Menu menu) {
        System.out.println(menu);
        String choice = scanner.next();
        menu.selectItem(choice);
    }

    public void print(String message) {
        view.update(message);
        view.display();
    }

    public void display(String data) {
        data += "\n\n *** appuyer sur 'q' pour retourner au dernier menu\n";
        view.update(data);
        view.display();
        String input;
        do {
            input = scanner.next();
        } while (!input.equals("q"));
    }

    protected abstract void initMenu();

}
