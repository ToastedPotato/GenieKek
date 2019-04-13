package ui.command;

public class RedoCommand implements Command {

    private CommandController controller;

    public RedoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public boolean execute() {
        Command command = controller.redo();
        if (command == null) return false;
        controller.execute(command);
        return true;
    }

    @Override
    public boolean unexecute() {
        return false;
    }
}
