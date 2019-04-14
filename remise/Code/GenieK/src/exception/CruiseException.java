package exception;

public class CruiseException extends SystemException {

    public CruiseException(){
        super("Les stations de départ et d'arrivé ne sont pas identiques");
    }
}
