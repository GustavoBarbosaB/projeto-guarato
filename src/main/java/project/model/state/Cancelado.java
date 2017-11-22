package project.model.state;

import project.model.Pedido;

public class Cancelado extends State {

    public Cancelado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public State nextState() {
        return new Cancelado(this.getPedido());
    }

    @Override
    public String getState() {
        return "Cancelado";
    }

    @Override
    public boolean change() {
        return false;
    }
}