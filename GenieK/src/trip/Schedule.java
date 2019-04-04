package trip;

import transport.Transport;

import java.util.Date;

public class Schedule {

    private Date depart;
    private Date arrive;
    private Transport transport;

    public Schedule(Date depart, Date arrive, Transport transport) {
        this.depart = depart;
        this.arrive = arrive;
        this.transport = transport;
    }
}
