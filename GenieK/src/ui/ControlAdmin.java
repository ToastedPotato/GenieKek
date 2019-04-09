package ui;

import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import station.Aeroport;
import station.Station;
import ui.menu.*;
import visitor.Admin;

public class ControlAdmin extends Control {

    //String contenant les options de recherche de vol/croisière/trajet de train
    private Menu
            stationManagementMenu,
            companyManagementMenu,
            stationCreateMenu;

    public ControlAdmin() {
        super();
        visitor = new Admin();
        show();
    }

    protected void initMenu() {
        // Instancie les menus
        mainMenu = new Menu(this, "Tableau de bord administrateur");
        stationManagementMenu = new Menu(this, mainMenu, "Management des Stations");
        companyManagementMenu = new Menu(this, mainMenu, "Management des Compagnies");
        stationCreateMenu = new Menu(this, stationManagementMenu, "Création de station");



        /* Station Create Menu
           -------------------
         */
        stationCreateMenu.addItem("1", "Créer un aéroport", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = AeroportFactory.getInstance().createStation(inputs.get("ID"), inputs.get("CITY"));
                        if (station == null) return;
                        dataBase.addStation(station);
                    }
                },
                new Field("ID", "Aérport ID"),
                new Field("CITY", "Ville"));
        stationCreateMenu.addItem("2", "Créer une gare", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = RailwayFactory.getInstance().createStation(inputs.get("ID"), inputs.get("CITY"));
                        if (station == null) return;
                        dataBase.addStation(station);
                    }
                },
                new Field("ID", "Gare ID"),
                new Field("CITY", "Ville"));
        stationCreateMenu.addItem("3", "Créer un port", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = PortFactory.getInstance().createStation(inputs.get("ID"), inputs.get("CITY"));
                        if (station == null) return;
                        dataBase.addStation(station);
                    }
                },
                new Field("ID", "Port ID"),
                new Field("CITY", "Ville"));



        /* Station Management Menu
           -----------------------
         */
        stationManagementMenu.addItem("1", "Créer", stationCreateMenu);
        stationManagementMenu.addItem("2", "Modifier", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = dataBase.getStation(inputs.get("STATION"));
                        if (station == null) return;
                        station.setId(inputs.get("ID"));
                        station.setCity(inputs.get("CITY"));
                    }
                },
                new Field("STATION", "Station ID"),
                new Field("ID", "Nouvel ID"),
                new Field("CITY", "Nouvelle ville"));
        stationManagementMenu.addItem("3", "Supprimer", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        print(inputs.toString());
                    }
                },
                new Field("STATION", "Station ID"));
        stationManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                display(DataBase.getInstance().stationsToString(visitor));
            }
        });



        /* Company Management Menu
           -----------------------
         */
        companyManagementMenu.addItem("1", "Créer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Créer");
            }
        });
        companyManagementMenu.addItem("2", "Modifier", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Modifier");
            }
        });
        companyManagementMenu.addItem("3", "Supprimer", new MenuItemListener() {
            @Override
            public void onSelect() {
                System.out.println("*** Supprimer");
            }
        });
        companyManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                    display(DataBase.getInstance().companiesToString(visitor));
            }
        });



        /* Main Menu
           ---------
         */
        mainMenu.addItem("1", "Station", stationManagementMenu);
        mainMenu.addItem("2", "Compagnie", companyManagementMenu);
    }
}

