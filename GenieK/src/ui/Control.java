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

    private boolean FLAG_CMD = false;

    private HashMap<String, Command> commands = new HashMap<>();

    public Control(Visitor visitor) {
        dataBase = DataBase.getInstance();
        commandController = new CommandController();
        view = new View();
        commands.put("undo", new UndoCommand(commandController));
        commands.put("redo", new RedoCommand(commandController));
        this.visitor = visitor;
        show();
    }

    private void showCommand(String cmd, String desc) {
        cmd = Console.colorize(Console.GREEN, cmd);
        println("- " + cmd + " : " + desc);
    }

    protected void show() {
        println(Console.menu("Commandes"));
        showCommand("quit", "quitte l'application à tout moment");
        showCommand("undo","annule l'action la plus récente");
        showCommand("redo","réapplique l'action annulée la plus récente");
        println("\n");
        initMenu();
        listen(mainMenu);
    }

    public void listen(Menu menu) {
        if (!FLAG_CMD) println(menu.toString());
        else FLAG_CMD = false;
        print("> ");
        String choice = scanner.next();
        while (!menu.selectItem(choice) && !applyCommand(choice)) {
            println(Console.colorize(Console.RED, "La commande '" + choice + "' n'existe pas"));
            print("> ");
            choice = scanner.next();
        }
        listen(menu);
    }

    public String listen(String message) {
        print(message + ": ");
        return scanner.next();
    }

    public boolean choice(String message) {
        println(message + " y/n");
        print("> ");
        String choice = scanner.next();
        return choice.equals("y") || choice.equals("Y");
    }

    private boolean applyCommand(String command) {
        if (command.equals("quit")) System.exit(0);
        if (!commands.containsKey(command)) return false;
        if (commands.get(command).execute()) printsuc("# commande exécutée");
        FLAG_CMD = true;
        return true;
    }

    public void printsuc(String message) {
        println(Console.colorize(Console.GREEN, message));
    }

    public void printerr(String message) {
        println(Console.colorize(Console.RED, message));
    }

    public void printne(String object) {
        printerr("L'élément [" + object + "] n'existe pas dans la base de donnée");
    }

    public void println(String message) {
        view.update(message);
        view.println();
    }

    public void print(String message) {
        view.update(message);
        view.print();
    }

    public void display(String data) {
        println(Console.section());
        println(data);
        println(Console.section());
        waitin();
    }

    public void waitin() {
        print("\"Entrée\" pour continuer");
        scanner.nextLine();
        scanner.nextLine();
    }

    protected abstract void initMenu();

}
