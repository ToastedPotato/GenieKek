package ui.command;

import java.util.ArrayList;

public class CommandController {

    private ArrayList<Command> undo = new ArrayList<>();
    private ArrayList<Command> redo = new ArrayList<>();

    public void execute(Command command) {
        if (!(command instanceof UndoCommand) && !(command instanceof RedoCommand))
            this.undo.add(command);
        command.execute();
    }

    public void unexecute(Command command) {
        if (!(command instanceof UndoCommand) && !(command instanceof RedoCommand))
            this.redo.add(command);
        command.unexecute();
    }

    Command undo() {
        Command command = undo.get(undo.size());
        redo.add(command);
        undo.remove(command);
        return command;
    }

    Command redo() {
        Command command = redo.get(redo.size());
        undo.add(command);
        redo.remove(command);
        return command;
    }
}
