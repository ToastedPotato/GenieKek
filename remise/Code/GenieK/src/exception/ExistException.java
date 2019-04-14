package exception;

public class ExistException extends SystemException {

    public ExistException(String id) {
        super("L'élément [" + id + "] existe déjà dans la base de donnée");
    }
}
