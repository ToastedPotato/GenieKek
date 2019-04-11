package ui.menu;

public class Field {

    public enum Input {
        ID ("Id"),
        NEW_ID ("Nouvel Id"),
        NAME ("Nom"),
        CITY ("Ville"),
        CITYSTART ("Ville de départ"),
        CITYARRIVAL ("Ville d'arrivé"),
        PRICE ("Prix"),
        TYPE ("Type"),
        DISPO ("Disposition"),
        SEAT ("Nombre de siège"),
        CABIN ("Nombre de cabine"),
        SECTION ("La classe souhaitée"),
        DATE ("Date de départ (yyyy.MM.dd)"),
        NUM ("Nombre"),
        DEP ("Station Id de depart"),
        ARR ("Station Id d'arrivée"),
        TRANS_ID("Tranport Id")
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
