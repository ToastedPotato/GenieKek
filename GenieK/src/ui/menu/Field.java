package ui.menu;

public class Field {

    public enum Input {
        ID ("Id"),
        NEW_ID ("Nouvel Id"),
        NAME ("Nom"),
        CITY ("Ville"),
        PRICE ("Prix")
        ;

        private final String text;

        Input(String text) {
            this.text = text;
        }
    }

    private String id, text;

    public Field(Input input) {
        this(input.toString(), input.text);
    }

    public Field(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
