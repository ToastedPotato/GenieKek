package ui.command;

public class UndoCommand implements Command {

    private CommandController controller;

    public UndoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.unexecute(controller.undo());
    }

    @Override
    public void unexecute() {

    }
}
