package reservation;

public class Confirmation{
    
    private String resNum, name, address, mail, phoneNumber, birthDate, passeportNum, expirationPasseportDate;
    private float price;

    public Confirmation(String name, String address, String mail, String phoneNumber, String birthDate, String passeportNum, String expirationPasseportDate) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.passeportNum = passeportNum;
        this.expirationPasseportDate = expirationPasseportDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setResNum(String resNum) {
        this.resNum = resNum;
    }

    public String getResNum() {
        return resNum;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPasseportNum() {
        return passeportNum;
    }

    public String getExpirationPasseportDate() {
        return expirationPasseportDate;
    }

    public float getPrice() {
        return price;
    }
}
