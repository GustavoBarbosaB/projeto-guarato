package project.model.item;

import javax.persistence.Entity;

public class ListItem {

    private int qtd;
    private int id;

    protected ListItem()
    {
    }

    ListItem(int qtd, int id)
    {
        this.qtd = qtd;
        this.id = id;
    }



}
