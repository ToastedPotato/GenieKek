package ui;

import company.Company;
import reservation.Confirmation;
import reservation.Reservation;
import transport.Transport;
import transport.section.Section;
import trip.Trip;
import ui.menu.*;
import visitor.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ControlClient extends Control{

    private String selectedSectionId = "";
    private Reservation selectedReservation = null;

    public ControlClient() {
        super(new Client());
    }

    private boolean compareDate(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        if(c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) return false;
        if(c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) return false;
        return c1.get(Calendar.DATE) == c2.get(Calendar.DATE);
    }

    private String searchTrip(ArrayList<Company> companies,String startCity, String endCity, String depart, String sectionId){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy.MM.dd").parse(depart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        selectedSectionId = sectionId;
        String result = "";
        for (Company c : companies) result += searchTripCompany(c, startCity, endCity, date, sectionId);
        String display = Console.section() + "\n";
        display += result;
        display += Console.section();
        return display;
    }

    private String searchTripCompany(Company company, String startCity, String endCity, Date departureDate, String sectionId) {
        String result = "";
        for (Trip t : company.getTrips()) {
            if(t.getDepart().getCity().equals(startCity)
                    && t.getArrive().getCity().equals(endCity)
                    && compareDate(t.getDepartureDate(), departureDate)
                    && t.haveSectionDispo(sectionId)){
                result += visitor.visit(t, sectionId) + "\n";
            }
        }
        return result;
    }

    @Override
    protected void initMenu() {
        mainMenu = new Menu(this, "Tableau de consultation Client");
        Menu chooseTransport = new Menu(this, mainMenu, "Choisisez votre moyen de transport");
        Menu reservationMenu = new Menu(this, chooseTransport);

        FieldGroup searchTripFields = new FieldGroup(
                new Field(Field.Input.CITY_START),
                new Field(Field.Input.CITY_ARRIVAL),
                new Field(Field.Input.DATE_DEP),
                new Field(Field.Input.SECTION));
        FieldGroup payementFields = new FieldGroup(
                new Field(Field.Input.NAME),
                new Field(Field.Input.ADDRESS),
                new Field(Field.Input.MAIL),
                new Field(Field.Input.PHONE_NUM),
                new Field(Field.Input.BIRTH_DATE),
                new Field(Field.Input.PASSEPORT),
                new Field(Field.Input.EXPIRATION_PASSEPORT_DATE));

        reservationMenu.addItem("1", "Réserver une place dans un voyage",
            "Rentrez l'{Id} du voyage pour réserver une place dans la section choisie",
            new Field(Field.Input.ID), new MenuInputCompleted() {
                @Override
                public void onCompleted(MenuInput inputs) {
                    Company company = dataBase.getCompanyByTrip(inputs.get(Field.Input.ID));
                    if (company == null) return;
                    String numResa = company.reservePlace(inputs.get(Field.Input.ID), selectedSectionId);
                    display("Votre numéro de réservation est: " + Console.colorize(Console.YELLOW_UNDERLINED, numResa));
                    listen(mainMenu);
                }
        });
        reservationMenu.addItem("2", "Nouvelle recherche", chooseTransport);
        reservationMenu.addItem("3", "Sortir", mainMenu);

        chooseTransport.addItem("1", "Voyager par avion", searchTripFields, new MenuInputCompleted() {
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
        chooseTransport.addItem("2", "Voyager par train", searchTripFields, new MenuInputCompleted() {
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
        chooseTransport.addItem("3", "Voyager par bateau", searchTripFields, new MenuInputCompleted() {
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
        mainMenu.addItem("2","Organisez vos reservations",
                "Rentrez votre {Numéro de réservation} pour y effectuer des actions",
                new Field(Field.Input.RES_ID) , new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                Reservation reservation = dataBase.getReservation(inputs.get(Field.Input.RES_ID));
                if (reservation == null) { printne(inputs.get(Field.Input.RES_ID)); return; }
                println(visitor.visit(reservation));
                Menu menu = new Menu(ControlClient.this, mainMenu, "Gestion de la réservation: " + inputs.get(Field.Input.RES_ID));
                if (reservation.isConfirmed() && reservation.isCancelable()) {
                    float refund = reservation.calculPrice() * 0.9f;
                    menu.addItem("1", "Annuler la réservation (remboursement de $" + refund + ")", new MenuItemListener() {
                        @Override
                        public void onSelect() {
                            reservation.cancel();
                            printsuc("- réservation annulée");
                            menu.back();
                        }
                    });
                    menu.addItem("2", "Changer de vol pour la même destination dans la même section (sans frais)", new MenuItemListener() {
                        @Override
                        public void onSelect() {
                            Company company = dataBase.getCompany(reservation.getCompanyId());
                            Trip trip = dataBase.getTrip(reservation.getTripId());
                            println(searchTripCompany(company, trip.getDepart().getCity(), trip.getArrive().getCity(), new Date(), reservation.getSectionId()));
                            String tripId = listen("Nouveau voyage Id");
                            if (!dataBase.tripExist(tripId)) { printne(tripId); return; }
                            if (!choice("Êtes-vous sûr de changer de voyage ?")) return;
                            // annule l'ancienne réservation
                            reservation.cancel();
                            // créer une nouvelle réservation
                            String numResa = company.reservePlace(tripId, reservation.getSectionId());
                            // récupère cette réservation et la paie directement
                            Reservation newReservation = dataBase.getReservation(numResa);
                            newReservation.pay(reservation.getConfirmation());
                            // affiche le nouveau numéro de réservation
                            printsuc("* réservation modifié");
                            println("Votre nouveau numéro de réservation est: " + Console.colorize(Console.YELLOW_UNDERLINED, numResa));
                            display(visitor.visit(newReservation.getConfirmation()));
                            menu.back();
                        }
                    });
                    menu.addItem("3", "Changer la classe", new MenuItemListener() {
                        @Override
                        public void onSelect() {
                            Trip trip = dataBase.getTrip(reservation.getTripId());
                            Transport transport = trip.getTransport();
                            // prix de la compagnie et prix de la réservation
                            int companyPrice = dataBase.getCompanyPrice(reservation.getCompanyId());
                            float originalPrice = reservation.calculPrice();
                            // affiche les sections disponibles dans ce transport
                            println(Console.section());
                            ArrayList<String> sectionIdDispo = new ArrayList<>();
                            for (Section section : transport.getSections()) {
                                if (!section.isFull() && !section.getStr().equals(reservation.getSectionId())) {
                                    // ajoute la sectionId dans une liste pour vérifier la valeur rentrée par l'utilisateur
                                    sectionIdDispo.add(section.getStr());
                                    // calcul le nouveau prix et la différence
                                    float price = section.calculPrice(companyPrice);
                                    println("[" + section.getStr() + "] "
                                            + Console.colorize(Console.BLUE, Integer.toString(section.getNbPlacesDispo()))
                                            + " places disponibles à $"
                                            + Console.colorize(Console.BLUE, Float.toString(price))
                                            + " (" + (price > originalPrice ? "+" : "-") + " $" + (Math.abs(price - originalPrice)) + ")");
                                }
                            }
                            println(Console.section());
                            String sectionId = listen("Nouvelle section Id");
                            // vérifie l'id rentré
                            if (!sectionIdDispo.contains(sectionId)) {
                                printerr("La section [" + sectionId + "] n'existe pas ou n'est pas libre");
                                return;
                            }
                            // calcul le nouveau prix
                            float newPrice = trip.getSection(sectionId).calculPrice(companyPrice);
                            float toPay;
                            if (originalPrice > newPrice) toPay = originalPrice - newPrice;
                            else toPay = newPrice - originalPrice;
                            toPay *= 0.9f;
                            if (!choice("Êtes-vous sûr de changer de section et " + (originalPrice > newPrice ? "se faire rembourser de" : "payer") + " $" + toPay + " ?")) return;
                            // change la section du siège
                            reservation.setSectionId(sectionId);
                            // change la place en libérant l'ancien et en confirmant le nouveau
                            reservation.changePlace(trip.pickFreePlace(sectionId));
                            printsuc("* section modifiée");
                            menu.back();
                        }
                    });
                }
                else {
                    menu.addItem("1", "Payer la place ($" + reservation.calculPrice() + ")", payementFields, new MenuInputCompleted() {
                        @Override
                        public void onCompleted(MenuInput inputs) {
                            Confirmation confirmation = reservation.pay(new Confirmation(
                                    inputs.get(Field.Input.NAME),
                                    inputs.get(Field.Input.ADDRESS),
                                    inputs.get(Field.Input.MAIL),
                                    inputs.get(Field.Input.PHONE_NUM),
                                    inputs.get(Field.Input.BIRTH_DATE),
                                    inputs.get(Field.Input.PASSEPORT),
                                    inputs.get(Field.Input.EXPIRATION_PASSEPORT_DATE)));
                            printsuc("$ place payée");
                            display(visitor.visit(confirmation));
                            menu.back();
                        }
                    });
                    menu.addItem("2", "Annuler la réservation (gratuit)", new MenuItemListener() {
                        @Override
                        public void onSelect() {
                            reservation.cancel();
                            printsuc("- place annulée");
                            menu.back();
                        }
                    });
                }
                listen(menu);
            }
        });
    }
}
