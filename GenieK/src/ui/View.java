package ui;

public class View {

    private String output = "";
    public static boolean CONSOLE_ENABLE = false;
    
    void update(String message) {
        this.output = message;
    }

    void println() {
        System.out.println(output);
    }

    void print() {
        System.out.print(output);
    }
}
