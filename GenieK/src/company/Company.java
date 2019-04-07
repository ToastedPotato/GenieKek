package company;

import factory.transport.*;
import transport.Transport;

public class Company {

    private TransportFactory transportFactory;
    private String id, name;
    private int price;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

}
