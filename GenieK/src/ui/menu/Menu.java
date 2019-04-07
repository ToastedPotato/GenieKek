package ui.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<String, MenuItem> menuItems =  new HashMap<>();
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public void addItem(String id, String text, MenuItemListener menuItemListener) {
        menuItems.put(id, new MenuItem(id, text, menuItemListener));
    }

    public void selectItem(String input) {
        menuItems.get(input).select();
    }

    public String toString() {
        StringBuilder text = new StringBuilder(title + "\n----------------------------------\n");
        for(Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            text.append(entry.getValue().toString());
        }
        return text.toString();
    }
}
