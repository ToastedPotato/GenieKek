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

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}