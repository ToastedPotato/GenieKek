package station;

public class IdException extends Exception {

    public IdException(String id) {
        System.out.println("L'id : " + id + " doit avoir 3 caractères");
    }
}
