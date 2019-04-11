package exception;

import ui.Console;

public class SystemException extends Exception{

    public SystemException(String msg) {
        System.out.println(Console.colorize(Console.RED, msg));
    }
}
