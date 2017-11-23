package project.model.state;

import project.model.Pedido;

import javax.persistence.Entity;

@Entity
public class Pendente extends State {

    public Pendente(Pedido pedido) {
        super(pedido);
    }

    @Override
    public State nextState() {
        return new Finalizado(this.getPedido());
    }

    public static State cancel(Pedido pedido){
        return new Cancelado(pedido);
    }

    @Override
    public String getState() {
        return "Pendente";
    }

    @Override
    public boolean change() {
        return true;
    }
}