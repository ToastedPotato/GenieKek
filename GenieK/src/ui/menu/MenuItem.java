package ui.menu;

public class MenuItem {

    private String id, text;
    private MenuItemListener listener;

    public MenuItem(String id, String text, MenuItemListener listener) {
        this.id = id;
        this.text = text;
        this.listener = listener;
    }

    public boolean select() {
        return listener.onSelect();
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return "    [" + id + "] - " + text + "\n";
    }
}
