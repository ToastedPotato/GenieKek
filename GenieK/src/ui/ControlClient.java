package ui;

import java.util.*;

import company.Company;
import reservation.Reservation;
import trip.Trip;
import ui.menu.*;
import visitor.Client;

public class ControlClient extends Control{

    private String selectedSectionId = "";
    private Reservation selectedReservation = null;

    public ControlClient() {
        super(new Client());
    }

    private String searchTrip(ArrayList<Company> companies,String startCity, String endCity, String depart, String sectionId){
        // TODO filtrage avec la date
       /* Date date = null;
        try {
            date = new SimpleDateFormat("yyyy.MM.dd").parse(depart);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        selectedSectionId = sectionId;
        String result = "";
        int i = 0;
        for (Company c : companies) {
            for (Trip t : c.getTrips()) {
                if(t.getDepart().getCity().equals(startCity)
                        && t.getArrive().getCity().equals(endCity)
                        //&& t.getDepartureDate().equals(date)
                        && t.haveSectionDispo(sectionId)){
                    result += visitor.visit(t, sectionId);
                    i++;
                }
            }
        }
        String display = Console.section();
        display += "\n" + Console.colorize(Console.WHITE_BOLD, (i + " résultat" + (i > 1 ? "s" : ""))) + "\n";
        display += result + "\n";
        display += Console.section();
        return display;
    }

    @Override
    protected void initMenu() {
        mainMenu = new Menu(this, "Tableau de consultation Client");
        Menu chooseTransport = new Menu(this, mainMenu, "Choisisez votre moyen de transport");
        Menu reservationMenu = new Menu(this, chooseTransport);

        FieldGroup searchTrip = new FieldGroup(
                new Field(Field.Input.CITY_START),
                new Field(Field.Input.CITY_ARRIVAL),
                new Field(Field.Input.DATE),
                new Field(Field.Input.SECTION)
        );

        reservationMenu.addItem("1", "Réserver une place dans un voyage",
                "Rentrez l'{Id} du vol pour réserver un siège dans la section choisie",
                new Field(Field.Input.ID), new MenuInputCompleted() {
                    @Override
                    public void onCompleted(MenuInput inputs) {
                        Company company = dataBase.getCompanyByTrip(inputs.get(Field.Input.ID));
                        if (company == null) return;
                        String numResa =  company.reservePlace(inputs.get(Field.Input.ID), selectedSectionId);
                        display("Votre numéro de réservation est: " + Console.colorize(Console.YELLOW_UNDERLINED, numResa));
                        listen(mainMenu);
                    }
                });
        reservationMenu.addItem("2", "Nouvelle recherche", chooseTransport);
        reservationMenu.addItem("3", "Sortir", mainMenu);

        chooseTransport.addItem("1", "Voyager par avion", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                println(searchTrip(dataBase.getFlightCompany(),
                        inputs.get(Field.Input.CITY_START),
                        inputs.get(Field.Input.CITY_ARRIVAL),
                        inputs.get(Field.Input.DATE_DEP),
                        inputs.get(Field.Input.SECTION)));
                listen(reservationMenu);
            }
        });
        chooseTransport.addItem("2", "Voyager par train", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                println(searchTrip(dataBase.getTrainCompany(),
                        inputs.get(Field.Input.CITY_START),
                        inputs.get(Field.Input.CITY_ARRIVAL),
                        inputs.get(Field.Input.DATE_DEP),
                        inputs.get(Field.Input.SECTION)));
                listen(reservationMenu);
            }
        });
        chooseTransport.addItem("3", "Voyager par bateau", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                println(searchTrip(dataBase.getCruiseCompany(),
                        inputs.get(Field.Input.CITY_START),
                        inputs.get(Field.Input.CITY_ARRIVAL),
                        inputs.get(Field.Input.DATE_DEP),
                        inputs.get(Field.Input.SECTION)));
                listen(reservationMenu);
            }
        });

        mainMenu.addItem("1","Rechercher un voyage", chooseTransport);
        mainMenu.addItem("2","Organisez vos reservation",
                "Rentrez votre {Numéro de réservation} pour y effectuer des actions",
                new Field(Field.Input.RES_ID) , new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                Reservation reservation = dataBase.getReservation(inputs.get(Field.Input.RES_ID));
                if (reservation == null) {
                    println("Réservation inexstante");
                    return;
                }
                Menu menu = new Menu(ControlClient.this, mainMenu, "Gestion de la réservation: " + inputs.get(Field.Input.RES_ID));
                // TODO choix menu pour action sur réservation
                listen(menu);
            }
        });
    }
}
