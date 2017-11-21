package project.model.item;

import javax.persistence.Entity;

public class ListItem {

    private int qtd;
    private int id;

    protected ListItem() {
    }

    ListItem(int qtd, int id) {
        this.qtd = qtd;
        this.id = id;
    }


    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
