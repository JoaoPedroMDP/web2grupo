package Beans;

import java.util.LinkedHashMap;

import Interfaces.Bean;
import Interfaces.Mappable;

public class Product implements Mappable, Bean{
    private int id;
    private String name;
    private String image;
    private Float weight;
    private int category_id;

    public Product() {}

    public Product(int id, String name, String image, Float weight, int category_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.category_id = category_id;
    }

    public Product(String name, String image, Float weight, int category_id) {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.category_id = category_id;
    }

    @Override
    public void fromMap(LinkedHashMap<String, Object> data) {
        this.setName((String) data.get("name"));
        this.setImage((String) data.get("image"));
        this.setWeight(Float.parseFloat( (String) data.get("weight")));
        this.setCategory_id(Integer.parseInt( (String) data.get("category_id")));
    }

    @Override
    public LinkedHashMap<String, Object> toMap() {
        LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("name", this.getName());
        data.put("image", this.getImage());
        data.put("weight", String.valueOf(this.getWeight()));
        data.put("category_id", String.valueOf(this.getCategory_id()));
        return data;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = Integer.parseInt(category_id);
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = Float.parseFloat(weight);
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
