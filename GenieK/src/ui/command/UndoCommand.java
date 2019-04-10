package ui.command;

public class UndoCommand implements Command {

    private CommandController controller;

    public UndoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Command command = controller.undo();
        if (command == null) return;
        controller.unexecute(command);
    }

    @Override
    public void unexecute() {

    }
}
