package project.model;

import java.util.List;

public class Pedido {

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    private Comprador comprador;
    private Vendedor vendedor;
    private List<Item> items;
}
