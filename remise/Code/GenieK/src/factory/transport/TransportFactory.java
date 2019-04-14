package factory.transport;

import transport.Transport;

public abstract class TransportFactory {

    protected abstract Transport fabricateTransport();

    public Transport createTransport(String id){
        Transport t = fabricateTransport();
        t.setId(id);
        return t;
    }
}
