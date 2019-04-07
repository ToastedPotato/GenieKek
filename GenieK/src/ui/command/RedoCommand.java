package ui.command;

public class RedoCommand implements Command {

    private CommandController controller;

    public RedoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.execute(controller.redo());
    }

    @Override
    public void unexecute() {

    }
}
