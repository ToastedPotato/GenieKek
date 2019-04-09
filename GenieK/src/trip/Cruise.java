package trip;

import station.Station;

public class Cruise extends Trip {

    @Override
    public void setStation(Station depart, Station arrive) {
        if(!depart.equals(arrive)) try {
            throw new CruiseException();
        } catch (CruiseException e) {
            e.printStackTrace();
        }
        super.setStation(depart, arrive);
    }
}
