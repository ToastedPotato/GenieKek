package company;

import factory.transport.*;
import transport.Transport;

public class Company {

    private TransportFactory transportFactory;
    private String id;
    private String name;

    public void setTransportFactory(TransportFactory transportFactory) {
        this.transportFactory = transportFactory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transport createTransport(String id){
        return transportFactory.createTransport(id);
    }
}
