package ui.menu;

import ui.Console;
import ui.Control;
import ui.SystemMain;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<String, MenuItem> menuItems =  new HashMap<>();
    private String originTitle, title = null;
    private Control control;
    private Menu parent = null;

    public Menu(Control control, Menu parent) {
        this.control = control;
        this.parent = parent;
    }

    public Menu(Control control, String title) {
        this.control = control;
        this.title = title;
        this.originTitle = title;
        addItem("q", "Quitter", new MenuItemListener() {
            @Override
            public void onSelect() {
                back();
            }
        });
    }

    public Menu(Control control, Menu parent, String title) {
        this.control = control;
        this.title = title;
        this.originTitle = title;
        this.parent = parent;
        addItem("q", "Retour au menu parent", new MenuItemListener() {
            @Override
            public void onSelect() {
                back();
            }
        });
    }

    public void back() {
        if (parent == null) SystemMain.choice();
        control.listen(parent);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu appendTitle(String append) {
        setTitle(originTitle + " " + append);
        return this;
    }

    public MenuItem getItem(String id) {
        if (!menuItems.containsKey(id)) return null;
        return menuItems.get(id);
    }

    public void addItem(String id, String text, MenuItemListener menuItemListener) {
        menuItems.put(id, new MenuItem(control, id, text, null, menuItemListener));
    }

    public void addItem(String id, String text, String description, FieldGroup fieldGroup, MenuInputCompleted menuInputCompleted) {
        menuItems.put(id, new MenuItem(control, id, text, description, new MenuItemListener() {
            @Override
            public void onSelect() {
                MenuInput menuInput = new MenuInput(control, fieldGroup);
                menuInput.display();
                menuInputCompleted.onCompleted(menuInput);
            }
        }));
    }

    public void addItem(String id, String text, FieldGroup fieldGroup, MenuItemListener menuItemListener, MenuInputCompleted menuInputCompleted) {
        menuItems.put(id, new MenuItem(control, id, text, null, new MenuItemListener() {
            @Override
            public void onSelect() {
                menuItemListener.onSelect();
                MenuInput menuInput = new MenuInput(control, fieldGroup);
                menuInput.display();
                menuInputCompleted.onCompleted(menuInput);
            }
        }));
    }

    public void addItem(String id, String text, FieldGroup fieldGroup, MenuInputCompleted menuInputCompleted) {
        addItem(id, text, null, fieldGroup, menuInputCompleted);
    }

    public void addItem(String id, String text, String description, Field field, MenuInputCompleted menuInputCompleted) {
        addItem(id, text, description, new FieldGroup(field), menuInputCompleted);
    }

    public void addItem(String id, String text, Field field, MenuInputCompleted menuInputCompleted) {
        addItem(id, text, null, new FieldGroup(field), menuInputCompleted);
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
        String string = "";
        if (title != null) {
            string += Console.menu(title) + "\n";
        }
        for(Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            string += entry.getValue().toString();
        }
        return string;
    }
}
