package ui.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class FieldGroup {

    private ArrayList<Field> fields = new ArrayList<>();

    public FieldGroup(Field ... fields) {
        this.fields.addAll(Arrays.asList(fields));
    }

    public ArrayList<Field> getFields() {
        return fields;
    }
}
