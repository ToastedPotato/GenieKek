package visitor;

import company.Company;
import place.Place;
import station.Station;
import transport.Transport;
import trip.Schedule;
import trip.Trip;

public class Admin implements Visitor{

    public String visit (Company company){
        return "ID:" + company.getId()+ " Nom:" +company.getName();
    }

    public String visit (Place place){
        return "Reservation:";
    }

    public String visit (Station station){
        return "ID:"+ station.getId() +" Ville:"+station.getCity();
    }

    public String visit (Transport transport){
        return "ID: " + transport.getId();
    }

    public String visit (Schedule schedule){
        return "Depart:"+ schedule.getDepart()+" Arrive:"+schedule.getArrive()+" TransportId:"+schedule.getTransport().getId();
    }

    public String visit (Trip trip){
        return "trip"; //trip.getDepart()+"-"+trip.getArrive()+":["+trip.getIdCompany()+"]"+planeName"("+dateDepart+"-"+dateArrive+")|"+sectionInfoDep+"|"+sectionInfoArr+")+price
    }

}


