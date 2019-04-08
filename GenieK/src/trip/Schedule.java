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

    public setDepart(Date depart) {
        this.depart = depart;
    }

    public getDepart() {
        return this.depart;
    }

    public setArrive(Date arrive){
       this.arrive = arrive;
    }

    public getArrive(){
        return this.arrive;
    }

    public setTransport(Transport transport){
        this.transport=transport;
    }

    public getTransport(){
        return this.transport;
    }



}