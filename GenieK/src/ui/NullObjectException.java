package ui;

public class NullObjectException extends Exception {

    public NullObjectException(String id) {
        System.out.println("L'objet " + id + " n'existe pas dans la base de données");
    }

}
