package ui.menu;

import ui.Console;
import ui.Control;

public class MenuItem {

    private String id, text, description;
    private MenuItemListener listener;
    private Control control;

    public MenuItem(Control control, String id, String text, String description, MenuItemListener listener) {
        this.control = control;
        this.id = id;
        this.text = text;
        this.description = description;
        this.listener = listener;
    }

    public void select() {
        if (description != null) control.println(description);
        listener.onSelect();
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return "[" + id + "] " + Console.colorize(Console.PURPLE, text) + "\n";
    }

    public String getDescription() {
        return description;
    }
}
