package visitor;

import company.Company;
import place.Place;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.Disposition;
import transport.section.OrganizableSection;
import trip.Schedule;
import trip.Trip;
import ui.Console;

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

        return visit(trip.getDepart()) + visit(trip.getArrive());

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