package utils.frontHelpers.table;

public class Action {
    private String link;
    private String text;
    private Boolean isIconizable;

    public Action(String label, String servlet, String action, Integer id, Boolean isIconizable) {
        this.link = this.generateLink( action, servlet, id);
        this.text = label;
        this.isIconizable = isIconizable;
    }

    public Action(String label, String link, Boolean isIconizable) {
        this.link = link;
        this.text = label;
        this.isIconizable = isIconizable;
    }

    private String generateLink(String action, String servlet, Integer id) {
        return servlet + "?action="+action+"&id=" + id;
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
