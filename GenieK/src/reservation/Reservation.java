package reservation;

import place.Place;
import place.state.Confirmed;
import place.state.Reserved;
import trip.Trip;
import ui.DataBase;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation{

    private static int number = 1;
    private String resNum, companyId, tripId, sectionId;
    private Confirmation confirmation;
    private Place place;

    public Reservation(String companyId, String tripId, String sectionId, Place place) {
        this.resNum = companyId + tripId + number;
        number++;
        this.place = place;
        this.companyId = companyId;
        this.tripId = tripId;
        this.sectionId = sectionId;
        place.setState(new Reserved());
        this.confirmation = null;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getResNum() {
        return resNum;
    }

    public boolean isConfirmed() {
        return confirmation != null;
    }

    public Confirmation pay(Confirmation confirmation) {
        if (isConfirmed()) return this.confirmation;
        place.payement();
        confirmation.setPrice(calculPrice());
        confirmation.setResNum(resNum);
        this.confirmation = confirmation;
        return confirmation;
    }

    public void changePlace(Place newPlace) {
        place.manage();
        place = newPlace;
        place.setState(new Confirmed());
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getTripId() {
        return tripId;
    }

    public boolean isCancelable() {
        Trip trip = DataBase.getInstance().getTrip(tripId);
        long dif = trip.getDepartureDate().getTime() - new Date().getTime();
        return TimeUnit.MILLISECONDS.toHours(dif) > place.getRequiredAnnulationTime();
    }

    public Confirmation getConfirmation(){
        return this.confirmation;
    }

    public void setConfirmation(Confirmation conf){
        this.confirmation = conf;
    }

    public String getDateToString() {
        Trip trip = DataBase.getInstance().getTrip(tripId);
        return trip.getDepartureDateToString() + "->" + trip.getArrivedDateToString();
    }

    public Place getPlace(){
        return this.place;
    }

    public void setPlace(Place place){
        this.place = place;
    }

    public float calculPrice() {
        Trip trip = DataBase.getInstance().getTrip(tripId);
        return trip.getSection(sectionId).calculPrice(DataBase.getInstance().getCompanyPrice(companyId));
    }

    public void cancel() {
        place.manage();
        place = null;
        DataBase.getInstance().getCompany(companyId).cancelReservation(this);
    }


}
