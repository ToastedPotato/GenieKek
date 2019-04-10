package ui;

import ui.command.Command;
import ui.command.CommandController;
import ui.command.RedoCommand;
import ui.command.UndoCommand;
import ui.menu.Menu;
import visitor.Visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Control {
    
    private View view;
    protected CommandController commandController;
    protected Menu mainMenu;
    protected Visitor visitor;
    protected DataBase dataBase;
    private Scanner scanner = new Scanner(System.in);

    private HashMap<String, Command> commands = new HashMap<>();

    public Control() {
        dataBase = DataBase.getInstance();
        commandController = new CommandController();
        view = new View();
        commands.put("undo", new UndoCommand(commandController));
        commands.put("redo", new RedoCommand(commandController));
    }

    protected void show() {
        display("[Commandes]");
        display("- exit : pour quitter à tout moment");
        for (Map.Entry<String, Command> commandMap : commands.entrySet()) {
            display("- " + commandMap.getKey());
        }
        display("\n");
        initMenu();
        listen(mainMenu);
    }

    public void listen(Menu menu) {
        display(menu.toString() + "\nVotre choix:");
        String choice = scanner.next();
        while (!menu.selectItem(choice) && !applyCommand(choice)) {
            display("La commande '" + choice + "' n'existe pas\nRéessayez:");
            choice = scanner.next();
        }
        listen(menu);
    }

    private boolean applyCommand(String command) {
        if (command.equals("exit")) System.exit(0);
        if (!commands.containsKey(command)) return false;
        commands.get(command).execute();
        return true;
    }

    public void display(String message) {
        view.update(message);
        view.display();
    }

    protected abstract void initMenu();

}
