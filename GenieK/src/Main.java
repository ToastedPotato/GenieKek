import ui.ControlAdmin;
import ui.DataBase;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello there !");

        DataBase.getInstance().init();
        new ControlAdmin();
    }

}
