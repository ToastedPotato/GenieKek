package visitor;

public class Client implements Visitor{


    public String visit (Company company){

        return "ID:"company.getId()+" Nom:"+company.getName();

    }

    public String visit (Place place){
        return "Reservation:"place.getRes()+ "Etat "place.getState()

    }

    public String visit (Station station){

        return "ID:"+ station.getId() +" Nom:"+station.getName()+ " Ville:"+station.city()

    }

    public String visit (Transport transport){

        return "ID: " transport.getId()

    }

    public String visit (Schedule schedule){

        return "Depart:"+ schedule.getDepart()+" Arrive:"+schedule.getArrive()+" Transport"+schedule.getTransport()

    }

    public String visit (Trip trip){

        return  "ID:"+trip.getId()+" Numero de voyage:"+ trip.getNumber()+ " Depart:"+trip.getArrive()+" ID Compagnie"+trip.getIdCompany()+ " Liste d'horaire:".getSchedules();

    }

    public String visit (TripWithStop tripWithStop){

        return  "ID:"+trip.getId()+" Numero de voyage:"+ trip.getNumber()+
                " Depart:"+tripWithStop.getArrive()+" ID Compagnie"+tripWithStop.getIdCompany()+ " Liste d'horaire:"tripWithStop.getSchedules();
        + "Liste d'arret:"+tripWithStop.getStops();
    }


}


