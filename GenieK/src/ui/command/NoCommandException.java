package ui.command;

public class NoCommandException extends Exception {

    public NoCommandException() {
        System.out.println("Aucune commande sur la pile");
    }
}
