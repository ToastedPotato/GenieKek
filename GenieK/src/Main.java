import ui.Control;
import ui.ControlAdmin;
import ui.ControlClient;
import ui.DataBase;

public class Main {

    public static void main(String[] args) {
        DataBase.getInstance().init();
        new ControlAdmin();
        //new ControlClient();
    }

}
