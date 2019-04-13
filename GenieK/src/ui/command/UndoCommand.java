package ui.command;

public class UndoCommand implements Command {

    private CommandController controller;

    public UndoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public boolean execute() {
        Command command = controller.undo();
        if (command == null) return false;
        controller.unexecute(command);
        return true;
    }

    @Override
    public boolean unexecute() {
        return false;
    }
}
