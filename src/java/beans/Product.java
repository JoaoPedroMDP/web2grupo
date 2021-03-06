package beans;

import java.util.LinkedHashMap;

import interfaces.Mappable;
import interfaces.Tableable;

public class Product extends BaseBean implements Mappable, Tableable{
    private Integer id;
    private String name;
    private String image;
    private Float weight;
    private Integer category_id;

    public Product() {
        this.servlet = "ProductServlet";
    }

    public Product(Integer id, String name, String image, Float weight, Integer category_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.category_id = category_id;
        this.servlet = "ProductServlet";
    }

    public Product(String name, String image, Float weight, Integer category_id) {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.category_id = category_id;
        this.servlet = "ProductServlet";
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

    @Override
    public String[] getColumns() {
        String[] columns = {"Número", "Nome", "Peso", "Ações"};
        return columns;
    }

    @Override
    public LinkedHashMap<String, LinkedHashMap<String, Object>> toTable() {
        LinkedHashMap<String, String> actions = new LinkedHashMap<String, String>(){{
            put("edit", "Editar");
            put("delete", "Excluir");
        }};
        LinkedHashMap<String, LinkedHashMap<String, Object>> data = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        data.put("Número", this.wrapData(this.getId(), false));
        data.put("Nome", this.wrapData(this.getName(), true));
        data.put("Peso", this.wrapData(this.getWeight(), true));
        data.put("Ações", this.wrapData(this.getActions(actions), false, true));
        return data;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
