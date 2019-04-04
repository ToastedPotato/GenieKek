package trip;

public class CruiseException extends Exception {
    public CruiseException(){
        System.out.println("Les Station de départ et d'arrivé ne sont pas identique");
    }
}
