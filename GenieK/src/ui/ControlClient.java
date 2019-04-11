package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;

import company.Company;
import station.Station;
import transport.Plane;
import transport.section.Section;
import trip.Trip;
import ui.menu.*;
import visitor.Client;

import javax.xml.crypto.Data;

public class ControlClient extends Control{

    public ControlClient() {
        super(new Client());
    }

    private String searchTrip(ArrayList<Company> companies,String startCity, String endCity, String depart){

        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy.MM.dd").parse(depart);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String display = "";

        for (Company c:companies) {

            for (Trip t:c.getTrips()) {

                if(t.getDepart().getCity().equals(startCity) && t.getArrive().getCity().equals(endCity) && t.getDepartureDate().equals(date)){

                    display += visitor.visit(t);

                }

            }

        }

        return display;

    }

    @Override
    protected void initMenu() {
        mainMenu = new Menu(this, "Tableau de consultation Client");
        Menu chooseTransport = new Menu( this, "Choisisez votre moyen de transport");
        Menu manageReservation = new Menu(this, "Organisez vos reservation");


        FieldGroup searchTrip = new FieldGroup(
                new Field(Field.Input.CITYSTART),
                new Field(Field.Input.CITYARRIVAL),
                new Field(Field.Input.DATE),
                new Field(Field.Input.SECTION)
        );

        chooseTransport.addItem("1", "Voyager par avions", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                display(searchTrip(dataBase.getFlightCompany(),inputs.get(Field.Input.CITYSTART),inputs.get(Field.Input.CITYARRIVAL),inputs.get(Field.Input.DATE)));
            }
        });
        chooseTransport.addItem("2", "Voyager par train", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                display(searchTrip(dataBase.getTrainCompany(),inputs.get(Field.Input.CITYSTART),inputs.get(Field.Input.CITYARRIVAL),inputs.get(Field.Input.DATE)));
            }
        });
        chooseTransport.addItem("3", "Voyager par bateau", searchTrip, new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                display(searchTrip(dataBase.getCruiseCompany(),inputs.get(Field.Input.CITYSTART),inputs.get(Field.Input.CITYARRIVAL),inputs.get(Field.Input.DATE)));
            }
        });

        mainMenu.addItem("1","Rechercher un voyage", chooseTransport);
        mainMenu.addItem("2", "Reserver un siège", new Field(Field.Input.ID) , new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                //TODO
            }
        });
        mainMenu.addItem("3","Organisez vos reservation",new Field(Field.Input.ID) , new MenuInputCompleted() {
            @Override
            public void onCompleted(MenuInput inputs) {
                //TODO
            }
        });
    }
}
