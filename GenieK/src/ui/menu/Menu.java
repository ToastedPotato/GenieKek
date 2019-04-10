package ui.menu;

import ui.Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<String, MenuItem> menuItems =  new HashMap<>();
    private String title;
    private Control control;

    public Menu(Control control, String title) {
        this.control = control;
        this.title = title;
        addItem("q", "Quitter", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.exit(0);
            }
        });
    }

    public Menu(Control control, Menu parent, String title) {
        this.control = control;
        this.title = title;
        addItem("q", "Retour au menu parent", new MenuItemListener() {
            @Override
            public void onSelect() {
                control.listen(parent);
            }
        });
    }

    public void addItem(String id, String text, MenuItemListener menuItemListener) {
        menuItems.put(id, new MenuItem(id, text, menuItemListener));
    }

    public void addItem(String id, String text, MenuInputCompleted menuInputCompleted, FieldGroup fieldGroup) {
        menuItems.put(id, new MenuItem(id, text, new MenuItemListener() {
            @Override
            public void onSelect() {
                MenuInput menuInput = new MenuInput(control, fieldGroup);
                menuInput.display();
                menuInputCompleted.onCompleted(menuInput);
            }
        }));
    }

    public void addItem(String id, String text, MenuInputCompleted menuInputCompleted, Field ... fields) {
        addItem(id, text, menuInputCompleted, new FieldGroup(fields));
    }

    public void addItem(String id, String text, Menu menu) {
        addItem(id, text, new MenuItemListener() {
            @Override
            public void onSelect() {
                control.listen(menu);
            }
        });
    }

    public boolean selectItem(String input) {
        if (!menuItems.containsKey(input)) return false;
        menuItems.get(input).select();
        return true;
    }

    public String toString() {
        StringBuilder text = new StringBuilder(title + "\n----------------------------------\n");
        for(Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            text.append(entry.getValue().toString());
        }
        return text.toString();
    }
}
