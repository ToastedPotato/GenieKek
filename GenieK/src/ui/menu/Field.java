package ui.menu;

public class Field {

    public enum Input {
        ID ("Id"),
        NEW_ID ("Nouvel Id"),
        NAME ("Nom"),
        CITY ("Ville"),
        CITY_START("Ville de départ"),
        CITY_ARRIVAL("Ville d'arrivé"),
        PRICE ("Prix"),
        TYPE ("Type"),
        DISPO ("Disposition"),
        SEAT ("Nombre de siège"),
        CABIN ("Nombre de cabine"),
        SECTION ("Section"),
        DATE("Date (yyyy.MM.dd)"),
        DATE_DEP("Date de départ (yyyy.MM.dd hh:mm)"),
        DATE_ARR("Date d'arrivée (yyyy.MM.dd hh:mm)"),
        NUM ("Nombre"),
        DEP ("Station Id de depart"),
        ARR ("Station Id d'arrivée"),
        TRANS_ID("Tranport Id"),
        RES_ID ("Num de réservation"),
        ADDRESS("Adresse"),
        MAIL ("Courriel"),
        PHONE_NUM ("Numéro de téléphone"),
        BIRTH_DATE ("Date de naissance (yyyy.MM.dd)"),
        PASSEPORT ("Numéro de passeport"),
        EXPIRATION_PASSEPORT_DATE ("Date d'expiration du passeport")
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
