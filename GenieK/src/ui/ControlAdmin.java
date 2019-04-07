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

    //String contenant les options de gestion de réservation: annuler, payer, etc.
    //private String reservationMenu;

    public ControlAdmin(){
        this.view = new View();
        initMenu();
    }

    public void listen(Menu menu){
        //La boucle d'exécution primaire du contrôleur

        boolean run = true;
        String choice = scanner.next();

        while(run){
            this.view.update(menu.toString());
            this.view.display();

            run = menu.selectItem(choice);
        }
        return;
    }

    public void initMenu(){
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

        compagnyManagementMenu.addItem("4", "Quitter", new MenuItemListener() {
            @Override
            public boolean onSelect() {
                    return false;
            }
        });

    }

}

