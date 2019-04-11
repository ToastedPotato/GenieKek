package exception;

public class SectionException extends SystemException {

    public SectionException(String item) {
        super("La section [" + item + "] existe déjà dans ce transport");
    }
}
