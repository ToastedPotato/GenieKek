package ui;

import company.Company;
import exception.NbPlaceException;
import exception.SectionException;
import factory.company.CruiseCompanyFactory;
import factory.company.FlightCompanyFactory;
import factory.company.TrainCompanyFactory;
import factory.station.AeroportFactory;
import factory.station.PortFactory;
import factory.station.RailwayFactory;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.Disposition;
import transport.section.OrganizableSection;
import transport.section.Section;
import trip.Trip;
import ui.command.AddInstanceTo;
import ui.command.DeleteInstanceFrom;
import ui.command.ModifyCompany;
import ui.command.ModifyStation;
import ui.menu.*;
import visitor.Admin;

public class ControlAdmin extends Control {

    private Company selectedCompany = null;
    private Transport onCreationTransport = null;

    private final static String DESC_STATION_CREATE = "Créer une nouvelle station en mentionnant son {Id} et sa {Ville}";
    private final static String DESC_COMPANY_CREATE = "Créer une nouvelle compagnie en mentionnant son {Id}, son {Nom} et le {Prix} de base";

    public ControlAdmin() {
        super(new Admin());
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
        Menu stationMenu = new Menu(this, mainMenu, "Gestion des stations");
        Menu companyMenu = new Menu(this, mainMenu, "Gestion des compagnies");
        Menu stationCreateMenu = new Menu(this, stationMenu, "Création de station");
        Menu companyCreateMenu = new Menu(this, companyMenu, "Création de compagnie");
        Menu companyManageMenu = new Menu(this, companyMenu, "Gestion de la compagnie :");
        Menu companyTransportMenu = new Menu(this, companyManageMenu, "Gestion des transports");
        Menu companyTripMenu = new Menu(this, companyManageMenu, "Gestion des voyages");
        Menu sectionOrganizedMenu = new Menu(this, companyTransportMenu);
        Menu sectionCabinMenu = new Menu(this, companyTransportMenu);

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
        FieldGroup createOrganizedSectionFields = new FieldGroup(
                new Field(Field.Input.TYPE),
                new Field(Field.Input.DISPO),
                new Field(Field.Input.SEAT));
        FieldGroup createCabinSectionFields = new FieldGroup(
                new Field(Field.Input.TYPE),
                new Field(Field.Input.CABIN));


        // Station Create Menu
        stationCreateMenu.addItem("1", "Créer un aéroport", DESC_STATION_CREATE, createStationFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(AeroportFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                        printsuc("+ aéroport créé");
                    }
                });
        stationCreateMenu.addItem("2", "Créer une gare", DESC_STATION_CREATE, createStationFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(RailwayFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                        printsuc("+ gare créée");
                    }
                });
        stationCreateMenu.addItem("3", "Créer un port", DESC_STATION_CREATE, createStationFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createStation(PortFactory.getInstance().createStation(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                        printsuc("+ port créé");
                    }
                });

        // Station Menu
        stationMenu.addItem("1", "Créer", stationCreateMenu);
        stationMenu.addItem("2", "Modifier",
                "Modifiez une station en fournissant son {Id} pour modifier son {Id} et sa {Ville}" ,
                modifyStationFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = dataBase.getStation(inputs.get(Field.Input.ID));
                        if (station == null) return;
                        commandController.execute(new ModifyStation(
                                station,
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.CITY)));
                        printsuc("* station modifiée");
                    }
                });
        stationMenu.addItem("3", "Supprimer",
                "Supprimez une station à partir de son {Id}",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Station station = dataBase.getStation(inputs.get(Field.Input.ID));
                        if (station == null) return;
                        commandController.execute(new DeleteInstanceFrom<>(dataBase.getStations(), station));
                        printsuc("- station supprimée");
                    }
                });
        stationMenu.addItem("4", "Afficher", new MenuItemListener() {
            @Override
            public void onSelect() {
                display(DataBase.getInstance().stationsToString(visitor));
            }
        });


        // Company Create Menu
        companyCreateMenu.addItem("1", "Créer une compagnie aérienne", DESC_COMPANY_CREATE, createCompanyFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(FlightCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.NAME),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                        printsuc("+ compagnie aérienne créée");
                    }
                });
        companyCreateMenu.addItem("2", "Créer une compagnie de train", DESC_COMPANY_CREATE, createCompanyFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(TrainCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.NAME),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                        printsuc("+ compagnie de train créée");
                    }
                });
        companyCreateMenu.addItem("3", "Créer une compagnie de croisière", DESC_COMPANY_CREATE, createCompanyFields, new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        createCompany(CruiseCompanyFactory.getInstance().createCompany(
                                inputs.get(Field.Input.ID),
                                inputs.get(Field.Input.NAME),
                                Integer.parseInt(inputs.get(Field.Input.PRICE))));
                        printsuc("+ compagnie de croisière créée");
                    }
                });

        sectionOrganizedMenu.addItem("1", "Ajouter une section", createOrganizedSectionFields, new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    Section section = null;
                    try {
                        OrganizableSection.Type type = OrganizableSection.Type.get(inputs.get(Field.Input.TYPE));
                        Disposition disposition = Disposition.get(inputs.get(Field.Input.DISPO));
                        int nbSeat = Integer.parseInt(inputs.get(Field.Input.SEAT));
                        if (type == null || disposition == null) return;
                        if (nbSeat <= 0) throw new NbPlaceException();
                        section = new OrganizableSection(type, disposition, nbSeat);
                        if (onCreationTransport.haveSection(section)) {
                            section = null;
                            throw new SectionException(inputs.get(Field.Input.TYPE));
                        }
                    } catch (NbPlaceException | SectionException ignored) { }
                    if (section == null) return;
                    onCreationTransport.addSection(section);
                    printsuc("+ section ajoutée");
                }
            });
        sectionOrganizedMenu.addItem("2", "Finaliser la création", new MenuItemListener() {
                @Override
                public void onSelect() {
                    commandController.execute(new AddInstanceTo<>(selectedCompany.getTransports(), onCreationTransport));
                    printsuc("+ transport créé");
                    sectionCabinMenu.back();
                }
            });

        sectionCabinMenu.addItem("1", "Ajouter une section", createCabinSectionFields, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                Section section = null;
                try {
                    CabinSection.Type type = CabinSection.Type.get(inputs.get(Field.Input.TYPE));
                    int nbCabin = Integer.parseInt(inputs.get(Field.Input.CABIN));
                    if (type == null) return;
                    if (nbCabin <= 0) throw new NbPlaceException();
                    section = new CabinSection(type, nbCabin);
                } catch (NbPlaceException ignored) { }
                if (section == null) return;
                onCreationTransport.addSection(section);
                printsuc("+ section ajoutée");
            }
        });
        sectionCabinMenu.addItem("2", "Finaliser la création", new MenuItemListener() {
                @Override
                public void onSelect() {
                    commandController.execute(new AddInstanceTo<>(selectedCompany.getTransports(), onCreationTransport));
                    printsuc("+ transport créé");
                    sectionCabinMenu.back();
                }
            });


        // Company Transport Menu
        companyTransportMenu.addItem("1", "Créer",
                "Créez un transport en choissant un {Id} ainsi que les sections et leur {Type} et {Disposition} ",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    onCreationTransport = selectedCompany.createTransport(inputs.get(Field.Input.ID));
                    if (onCreationTransport == null) return;
                    Menu menu = null;
                    println(Console.section());
                    println("{Type} de section disponible:");
                    if (onCreationTransport.getSectionClass() == OrganizableSection.class) {
                        menu = sectionOrganizedMenu;
                        for (OrganizableSection.Type type : OrganizableSection.Type.values()) {
                            println(type.print(visitor));
                        }
                        println(Console.section());
                        println("{Disposition} de section disponible:");
                        for (Disposition disposition : Disposition.values()) {
                            println(disposition.print(visitor));
                        }
                    }
                    else if (onCreationTransport.getSectionClass() == CabinSection.class) {
                        menu = sectionCabinMenu;
                        for (CabinSection.Type type : CabinSection.Type.values()) {
                            println(type.print(visitor));
                        }
                    }
                    println(Console.section());
                    if (menu == null) return;
                    listen(menu);
                }
            });
        companyTransportMenu.addItem("2", "Supprimer",
                "Supprimez un transport à partir de son {Id}",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    Transport transport = selectedCompany.getTransport(inputs.get(Field.Input.ID));
                    if (transport == null) return;
                    commandController.execute(new DeleteInstanceFrom<>(selectedCompany.getTransports(), transport));
                    printsuc("- transport supprimé");
                }
            });
        companyTransportMenu.addItem("3", "Afficher", new MenuItemListener() {
                @Override
                public void onSelect() {
                    display(selectedCompany.transportToString(visitor));
                }
            });

        // Company Trip Menu
        //companyTripMenu.addItem("1", "Créer", );
        //companyTripMenu.addItem("2", "Modifier", );
        companyTripMenu.addItem("3", "Supprimer",
                "Supprimez un voyage à partir de son {Id}",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    Trip trip = selectedCompany.getTrip(inputs.get(Field.Input.ID));
                    if (trip == null) return;
                    commandController.execute(new DeleteInstanceFrom<>(selectedCompany.getTrips(), trip));
                    printsuc("+ voyage créé");
                }
            });
        companyTripMenu.addItem("4", "Afficher", new MenuItemListener() {
                @Override
                public void onSelect() {
                    display(selectedCompany.tripToString(visitor));
                }
            });


        // Company Management Menu
        companyManageMenu.addItem("1", "Gérer les transports", companyTransportMenu);
        companyManageMenu.addItem("2", "Gérer les voyages", companyTripMenu);

        // Company Menu
        companyMenu.addItem("1", "Créer", companyCreateMenu);
        companyMenu.addItem("2", "Modifier",
                "Modifiez une compagnie en fournissant son {Id} pour modifier son {Id}, son {Nom} et son {Prix} de base",
                modifyCompanyFields, new MenuInputCompleted() {
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
                        printsuc("* compagie modifiée");
                    }
                });
        companyMenu.addItem("3", "Supprimer",
                "Supprimez une compagnie à partir de son {Id}",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Company company = dataBase.getCompany(inputs.get(Field.Input.ID));
                        if (company == null) return;
                        commandController.execute(new DeleteInstanceFrom<>(dataBase.getCompanies(), company));
                        printsuc("- compagie supprimée");
                    }
                });
        companyMenu.addItem("4", "Gestion d'une compagnie",
                "Rentrez l'{Id} de la compagnie à charger",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    Company company = dataBase.getCompany(inputs.get(Field.Input.ID));
                    if (company == null) return;
                    selectedCompany = company;
                    companyManageMenu.appendTitle(company.getName());
                    listen(companyManageMenu);
                }
            });
        companyMenu.addItem("5", "Afficher les compagnies" , new MenuItemListener() {
                @Override
                public void onSelect() {
                    display(DataBase.getInstance().companiesToString(visitor));
                }
            });


        // Main Menu
        mainMenu.addItem("1", "Station", stationMenu);
        mainMenu.addItem("2", "Compagnie", companyMenu);
    }
}