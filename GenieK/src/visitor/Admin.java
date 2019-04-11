package visitor;

import company.Company;
import place.Place;
import station.Station;
import transport.Transport;
import transport.section.CabinSection;
import transport.section.Disposition;
import transport.section.OrganizableSection;
import transport.section.Section;
import trip.Schedule;
import trip.Trip;
import ui.Console;
import ui.DataBase;


public class Admin implements Visitor{

    @Override
    public String visit (Company company){
        return "ID:" + company.getId()+ " Nom:" +company.getName() + " Prix:" + company.getPrice();
    }

    @Override
    public String visit (Place place){
        return "Reservation:";
    }

    @Override
    public String visit (Station station){
        return "ID:"+ station.getId() +" Ville:"+station.getCity();
    }

    @Override
    public String visit (Transport transport){
        String string = transport.getId() + ":[" + Console.colorize(Console.YELLOW, transport.getCompanyId()) + "]";
        boolean b = true;
        for (Section section : transport.getSections()) {
            string += (!b ? "|" : "") + section.getStr();
            b = false;
            if (section instanceof OrganizableSection) string += ((OrganizableSection) section).getDisposition().getStr();
            string += Console.colorize(Console.BLUE, Integer.toString(section.getNbPlaces()));
        }
        return string;
    }

    @Override
    public String visit (Schedule schedule){
        return "Depart:"+ schedule.getDepart()+" Arrive:"+schedule.getArrive()+" TransportId:"+schedule.getTransport().getId();
    }

    @Override
    public String visit (Trip trip){
        String string = trip.getDepart().getId() + "-" + trip.getArrive().getId() + ":[" + Console.colorize(Console.YELLOW,trip.getIdCompany()) + "]" + trip.getId() + "(date-depart.date-arrivee)";
        for (Section section : trip.getSections()) {
            string += "|" + section.getStr();
            if (section instanceof OrganizableSection) string += ((OrganizableSection) section).getDisposition().getStr();
            string += "(" + Console.colorize(Console.BLUE, Integer.toString(section.getNbPlacesReserved())) + "/" + section.getNbPlaces() + ")";
            string += Console.colorize(Console.RED, Float.toString(section.calculPrice(DataBase.getInstance().getCompanyPrice(trip.getIdCompany()))));
        }
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


