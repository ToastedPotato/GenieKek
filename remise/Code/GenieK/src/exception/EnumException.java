package exception;

public class EnumException extends SystemException {

    public EnumException(String item) {
        super("L'élément [" + item + "] n'existe pas dans la liste");
    }
}
