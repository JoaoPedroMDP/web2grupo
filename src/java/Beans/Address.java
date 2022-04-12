package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class Address implements Mappable, Bean{
    private int id;
    private String street;
    private String number;
    private String complement;
    private String district;
    private int zip_code;
    private String city;
    private String state;

    public Address() {}

    public Address(int id, String street, String number, String complement, String district, int zip_code, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.city = city;
        this.state = state;
    }

    public Address(String street, String number, String complement, String district, int zip_code, String city, String state) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.city = city;
        this.state = state;
    }

    @Override
    public void fromMap(LinkedHashMap<String, String> data) {
        this.setStreet(data.get("street"));
        this.setNumber(data.get("number"));
        this.setComplement(data.get("complement"));
        this.setDistrict(data.get("district"));
        this.setZip_code(Integer.parseInt(data.get("zip_code")));
        this.setCity(data.get("city"));
        this.setState(data.get("state"));
    }

    @Override
    public LinkedHashMap<String, String> toMap() {
        LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
        data.put("street", this.getStreet());
        data.put("number", this.getNumber());
        data.put("complement", this.getComplement());
        data.put("district", this.getDistrict());
        data.put("zip_code", String.valueOf(this.getZip_code()));
        data.put("city", this.getCity());
        data.put("state", this.getState());
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = Integer.parseInt(zip_code);
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
