package exception;

import ui.Console;
import ui.View;

public class SystemException extends Exception{

    public SystemException(String msg) {
        if (!View.CONSOLE_ENABLE) return;
        System.out.println(Console.colorize(Console.RED, msg));
    }
}
