package visitor;

import company.Company;
import reservation.Confirmation;
import reservation.Reservation;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.Disposition;
import transport.section.OrganizableSection;
import transport.section.Section;
import trip.Trip;
import ui.Console;
import ui.DataBase;

public class Client implements Visitor{

    @Override
    public String visit(Company company) {
        return null;
    }

    public String visit (Station station){

        return "ID:"+ station.getId() + " Ville:"+station.getCity();

    }

    public String visit (Transport transport){

        return "ID: " + transport.getId();

    }

    public String visit (Trip trip){
        return "";
    }

    @Override
    public String visit(Confirmation confirmation) {
        return Console.colorize(Console.YELLOW_UNDERLINED, confirmation.getResNum()) + "|" + confirmation.getPrice() + "|" + confirmation.getName();
    }

    @Override
    public String visit(Reservation reservation) {
        String string = Console.colorize(Console.YELLOW_UNDERLINED, reservation.getResNum());
        string += "|" + reservation.getDateToString();
        string += "|" + (reservation.isConfirmed() ? "CONFIRMÉ" : "EN ATTENTE DE PAIEMENT");
        if (reservation.isConfirmed())
            string += "|" + (reservation.isCancelable() ? "" : "NON ") + "ANNULABLE";
        return string;
    }

    @Override
    public String visit(Trip trip, String sectionStr) {
        String string = trip.getDepart().getId() + "-" + trip.getArrive().getId() + ":[" + Console.colorize(Console.YELLOW,trip.getCompanyId()) + "]" + trip.getId() +
                "(" + trip.getDepartureDateToString() + "->" + trip.getArrivedDateToString() + ")|";
        Section section = trip.getSection(sectionStr);
        string += Console.colorize(Console.RED, Float.toString(section.calculPrice(DataBase.getInstance().getCompanyPrice(trip.getCompanyId())))) + "|";
        string += sectionStr + Console.colorize(Console.BLUE, Integer.toString(section.getNbPlacesDispo()));
        return string;
    }

    @Override
    public String visit(OrganizableSection.Type type) {
        return "[" + type.getStr() + "] " + Console.colorize(Console.BLUE, type.toString()) + "  " +
                "\tratio: " + Console.colorize(Console.YELLOW, Integer.toString(type.getRatio())) + "%";
    }

    @Override
    public String visit(CabinSection.Type type) {
        return "[" + type.getStr() + "] " + Console.colorize(Console.BLUE, type.toString()) + "   " +
                "\tratio: " + Console.colorize(Console.YELLOW, Integer.toString(type.getRatio())) +
                "%\tcapacité des cabines: " + Console.colorize(Console.YELLOW, Integer.toString(type.getCapacity())) + " personnes)";
    }

    @Override
    public String visit(Disposition dispo) {
        return "[" + dispo.getStr() + "] " + Console.colorize(Console.BLUE, dispo.toString()) +
                "\t\tcolonnes: " + Console.colorize(Console.YELLOW, Integer.toString(dispo.getNbColumn())) + "  " +
                "\taile(s) entre les rangées " + Console.colorize(Console.YELLOW, dispo.getLanes());
    }

}