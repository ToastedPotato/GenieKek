package ui.command;

public class RedoCommand implements Command {

    private CommandController controller;

    public RedoCommand(CommandController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Command command = controller.redo();
        if (command == null) return;
        controller.execute(command);
    }

    @Override
    public void unexecute() {

    }
}
