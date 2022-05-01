package utils.frontHelpers;

public class ClickableItem {
    private String url;
    private String label;
    
    public ClickableItem(String label, String url){
        this.setUrl(url);
        this.setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}