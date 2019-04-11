package ui.command;

import exception.NoCommandException;

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
        if (undo.size() == 0) {
            try {
                throw new NoCommandException();
            } catch (NoCommandException ignored) {}
            return null;
        }
        Command command = undo.get(undo.size() - 1);
        redo.add(command);
        undo.remove(command);
        return command;
    }

    Command redo() {
        if (redo.size() == 0) {
            try {
                throw new NoCommandException();
            } catch (NoCommandException ignored) {}
            return null;
        }
        Command command = redo.get(redo.size() - 1);
        undo.add(command);
        redo.remove(command);
        return command;
    }
}
