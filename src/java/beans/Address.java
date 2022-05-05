package beans;

import java.util.LinkedHashMap;

import interfaces.Mappable;
import interfaces.Tableable;

public class Address extends BaseBean implements Mappable, Tableable{
    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String district;
    private Integer zip_code;
    private Integer city_id;

    public Address() {
        this.servlet = "AddressServlet";
    }

    public Address(Integer id, String street, String number, String complement, String district, Integer zip_code, Integer city_id) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.city_id = city_id;
        this.servlet = "AddressServlet";
    }

    public Address(String street, String number, String complement, String district, Integer zip_code, Integer city_id) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.city_id = city_id;
        this.servlet = "AddressServlet";
    }

    public Address(int id, String street, String number, String complement, String district, Integer zip_code) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.servlet = "AddressServlet";
    }
    
    public Address(String street, String number, String complement, String district, Integer zip_code) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zip_code = zip_code;
        this.servlet = "AddressServlet";
    }

    @Override
    public void fromMap(LinkedHashMap<String, Object> data) {
        this.setStreet( (String) data.get("street"));
        this.setNumber( (String) data.get("number"));
        this.setComplement( (String) data.get("complement"));
        this.setDistrict( (String) data.get("district"));
        this.setZip_code( (Integer) data.get("zip_code"));
        this.setCity_id( (Integer) data.get("city_id"));
    }

    @Override
    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("street", this.getStreet());
        data.put("number", this.getNumber());
        data.put("complement", this.getComplement());
        data.put("district", this.getDistrict());
        data.put("zip_code", String.valueOf(this.getZip_code()));
        data.put("city_id", this.getCity_id());
        return data;
    }

    @Override
    public String[] getColumns() {
        String[] columns = {"Rua", "Número", "Bairro", "CEP", "Ações"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, LinkedHashMap<String, Object>> toTable() {
        LinkedHashMap<String, LinkedHashMap<String, Object>> data = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        data.put("Rua", this.wrapData(this.getStreet(), true));
        data.put("Número", this.wrapData(this.getNumber(), false));
        data.put("Bairro", this.wrapData(this.getDistrict(), false));
        data.put("CEP", this.wrapData(this.getZip_code(), false));
        data.put("Ações", this.wrapData(this.getActions(), false, true));
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = Integer.parseInt(zip_code);
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = Integer.parseInt(city_id);
    }
}