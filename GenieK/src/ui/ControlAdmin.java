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

    protected void initMenu() {
        mainMenu = new Menu(this, "Tableau de bord administrateur");

        stationManagementMenu = new Menu(this, mainMenu, "Management des Stations");
        stationManagementMenu.addItem("1", "Créer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Créer");
            }
        });

        stationManagementMenu.addItem("2", "Modifier", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Modifier");
            }
        });

        stationManagementMenu.addItem("3", "Supprimer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Supprimer");
            }
        });

        stationManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                display(DataBase.getInstance().stationsToString(visitor));
            }
        });

        compagnyManagementMenu = new Menu(this, mainMenu, "Management des Compagnies");
        compagnyManagementMenu.addItem("1", "Créer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Créer");
            }
        });

        compagnyManagementMenu.addItem("2", "Modifier", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Modifier");
            }
        });

        compagnyManagementMenu.addItem("3", "Supprimer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Supprimer");
            }
        });

        compagnyManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                    display(DataBase.getInstance().companiesToString(visitor));
            }
        });

        mainMenu.addItem("1", "Station", stationManagementMenu);
        mainMenu.addItem("2", "Compagnie", compagnyManagementMenu);
    }
}

