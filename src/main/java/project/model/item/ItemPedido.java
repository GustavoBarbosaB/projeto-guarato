package project.model.item;

import project.model.Pedido;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    private int qtd;

    protected ItemPedido() {
    }

    ItemPedido(Item item, int qtd) {
        this.qtd = qtd;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
