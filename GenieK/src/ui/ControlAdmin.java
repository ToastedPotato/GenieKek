package ui;

import com.sun.xml.internal.bind.v2.model.core.ID;
import company.Company;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import station.Station;
import ui.command.AddInstanceTo;
import ui.command.DeleteInstanceFrom;
import ui.command.ModifyCompany;
import ui.command.ModifyStation;
import ui.menu.*;
import visitor.Admin;

public class ControlAdmin extends Control {

    public ControlAdmin() {
        super();
        visitor = new Admin();
        show();
    }


    private void createStation(Station station) {
        if (station == null) return;
        commandController.execute(new AddInstanceTo<>(dataBase.getStations(), station));
    }

    private void createCompany(Company company) {
        if (company == null) return;
        commandController.execute(new AddInstanceTo<>(dataBase.getCompanies(), company));
    }

    protected void initMenu() {
        // Instancie les menus
        mainMenu = new Menu(this, "Tableau de bord administrateur");
        Menu stationManagementMenu = new Menu(this, mainMenu, "Management des Stations");
        Menu companyManagementMenu = new Menu(this, mainMenu, "Management des Compagnies");
        Menu stationCreateMenu = new Menu(this, stationManagementMenu, "Création de station");
        Menu companyCreateMenu = new Menu(this, companyManagementMenu, "Création de compagnie");


        FieldGroup createStationFields = new FieldGroup(
                new Field(Field.Input.ID),
                new Field(Field.Input.CITY));
        FieldGroup modifyStationFields = new FieldGroup(
                new Field(Field.Input.ID),
                new Field(Field.Input.NEW_ID),
                new Field(Field.Input.CITY));
        FieldGroup createCompanyFields = new FieldGroup(
                new Field(Field.Input.ID),
                new Field(Field.Input.NAME),
                new Field(Field.Input.PRICE));
        FieldGroup modifyCompanyFields = new FieldGroup(
                new Field(Field.Input.ID),
                new Field(Field.Input.NEW_ID),
                new Field(Field.Input.NAME),
                new Field(Field.Input.PRICE));

        /* Station Create Menu
           -------------------
         */
        stationCreateMenu.addItem("1", "Créer un aéroport", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(AeroportFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                    }
                }, createStationFields);
        stationCreateMenu.addItem("2", "Créer une gare", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(RailwayFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                    }
                }, createStationFields);
        stationCreateMenu.addItem("3", "Créer un port", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(PortFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                    }
                }, createStationFields);



        /* Station Management Menu
           -----------------------
         */
        stationManagementMenu.addItem("1", "Créer", stationCreateMenu);
        stationManagementMenu.addItem("2", "Modifier", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = dataBase.getStation(inputs.get(Field.Input.ID));
                        if (station == null) return;
                        commandController.execute(new ModifyStation(
                                station,
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                    }
                }, modifyStationFields);
        stationManagementMenu.addItem("3", "Supprimer", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = dataBase.getStation(inputs.get(Field.Input.ID));
                        if (station == null) return;
                        commandController.execute(new DeleteInstanceFrom<>(dataBase.getStations(), station));
                    }
                }, new Field(Field.Input.ID));
        stationManagementMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                display(DataBase.getInstance().stationsToString(visitor));
            }
        });


        /* Company Create Menu
           -------------------
         */
        companyCreateMenu.addItem("1", "Créer une compagnie aérienne", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(FlightCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.NAME),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                    }
                }, createCompanyFields);
        companyCreateMenu.addItem("2", "Créer une compagnie de train", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(TrainCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                    }
                }, createCompanyFields);
        companyCreateMenu.addItem("3", "Créer une compagnie de croisière", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(CruiseCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                    }
                }, createCompanyFields);


        /* Company Management Menu
           -----------------------
         */
        companyManagementMenu.addItem("1", "Créer", companyCreateMenu);
        companyManagementMenu.addItem("2", "Modifier", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Company company = dataBase.getCompany(inputs.get(Field.Input.ID));
                        if (company == null) return;
                        commandController.execute(new ModifyCompany(
                                company,
                                inputs.get(Field.Input.NEW_ID),
                                inputs.get(Field.Input.NAME),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))
                                ));
                    }
                }, modifyCompanyFields);
        companyManagementMenu.addItem("3", "Supprimer", new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Company company = dataBase.getCompany(inputs.get(Field.Input.ID));
                        if (company == null) return;
                        commandController.execute(new DeleteInstanceFrom<>(dataBase.getCompanies(), company));
                    }
                }, new Field(Field.Input.ID));
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

