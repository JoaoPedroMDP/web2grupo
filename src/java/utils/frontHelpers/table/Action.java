package utils.frontHelpers.table;

public class Action {
    private String link;
    private String text;
    private Boolean isIconizable;
    
    public Action(String text, String link, Boolean isIconizable) {
        this.link = link;
        this.text = text;
        this.isIconizable = isIconizable;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsIconizable() {
        return isIconizable;
    }

    public void setIsIconizable(Boolean isIconizable) {
        this.isIconizable = isIconizable;
    }
}
