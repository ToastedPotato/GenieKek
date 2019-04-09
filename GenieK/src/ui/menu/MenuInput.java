package ui.menu;

import ui.Control;

import java.util.*;

public class MenuInput {

    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, String> inputs = new HashMap<>();
    private ArrayList<Field> fields = new ArrayList<>();
    private Control control;

    public MenuInput(Control control, Field ... fields) {
        this.control = control;
        this.fields.addAll(Arrays.asList(fields));
    }

    public void display() {
        for (Field field : fields) listen(field);
    }

    private void listen(Field field) {
        control.print(field.getText() + ":");
        String input = scanner.next();
        inputs.put(field.getId(), input);
    }

    public String get(String fieldId) {
        return inputs.get(fieldId);
    }

    public String toString() {
        StringBuilder string = new StringBuilder("Données rentrées :\n--------------\n");
        for (Map.Entry<String, String> entry : inputs.entrySet()) {
            string.append("[")
                    .append(entry.getKey())
                    .append("] = ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return string.toString();
    }

}
