package entities;

public class Reader {
    private static int autoId;
    private int id;
    private String name;
    private int numberPhone;
    private String address;

    public Reader(String name, int numberPhone, String address) {
        this.id = ++autoId;
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
