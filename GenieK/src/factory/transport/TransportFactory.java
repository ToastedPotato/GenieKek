package factory.transport;

import transport.Transport;

public abstract class TransportFactory {

    protected abstract Transport fabricateTransport();

    public Transport createTransport(String id, String companyId){
        Transport t = fabricateTransport();
        t.setId(id);
        t.setCompanyId(companyId);
        return t;
    }
}
