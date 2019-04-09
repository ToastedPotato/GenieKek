package station;

public class IdException extends Exception {

    public IdException(String id) {
        System.out.println("L'id : " + id + " a plus de 3 caractères");
    }
}
