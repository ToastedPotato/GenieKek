package ui;

import ui.menu.Menu;
import ui.menu.MenuItemListener;

import java.util.Scanner;

public class ControlAdmin extends Control {

    private Scanner scanner = new Scanner(System.in);

    //String contenant les options de recherche de vol/croisière/trajet de train
    private Menu stationManagementMenu;
    private Menu compagnyManagementMenu;

    private Menu stationCreationMenu;
    private Menu compagnyCreationManu;

    public ControlAdmin(){
        this.view = new View();
        initMenu();
    }

    private void listen(Menu menu){
        //La boucle d'exécution primaire du contrôleur
        boolean run = true;
        String choice = scanner.next();

        while(run){
            this.view.update(menu.toString());
            this.view.display();
            run = menu.selectItem(choice);
        }
    }

    private void displayer(String msg){
        //La boucle d'exécution primaire du contrôleur
        boolean run = true;
        String choice = scanner.next();

        msg += "press q to return to the last menu\n";

        while(run){
            // FIXME : boucle inutile, on affice et on attend la réponse de l'utilisateur,
            // là on affiche le message jusqu'à ce que l'admin quitte
            this.view.update(msg);
            this.view.display();
            if(choice.equals("q")) run = false;
        }
    }

    private void initMenu(){
        this.mainMenu = new Menu("Admin Dashboard");
        this.mainMenu.addItem("1", "Station", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    listen(stationManagementMenu);
                    return true;
            }
        });

        this.mainMenu.addItem("2", "Compagnie", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    listen(stationManagementMenu);
                    return true;
            }
        });

        this.mainMenu.addItem("3", "Quitter", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return false;
            }
        });

        stationManagementMenu = new Menu("Station Management");
        stationManagementMenu.addItem("1", "Créer", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        stationManagementMenu.addItem("2", "Modifier", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        stationManagementMenu.addItem("3", "Supprimer", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        stationManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                displayer(DataBase.getInstance().stationsToString(visitor));
                return true;
            }
        });

        stationManagementMenu.addItem("4", "Quitter", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return false;
            }
        });

        compagnyManagementMenu = new Menu("Company Management");
        compagnyManagementMenu.addItem("1", "Créer", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        compagnyManagementMenu.addItem("2", "Modifier", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        compagnyManagementMenu.addItem("3", "Supprimer", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return true;
            }
        });

        compagnyManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    displayer(DataBase.getInstance().companiesToString(visitor));
                    return true;
            }
        });

        compagnyManagementMenu.addItem("5", "Quitter", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                return false;
            }
        });

    }



}

