import ui.ControlAdmin;
import ui.DataBase;

public class Main {

    public static void main(String[] args) {
        DataBase.getInstance().init();
        new ControlAdmin();
    }

}
