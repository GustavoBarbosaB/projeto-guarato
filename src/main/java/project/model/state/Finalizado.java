package project.model.state;

import project.model.Pedido;

import javax.persistence.Entity;

@Entity
public class Finalizado extends State {

    public Finalizado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public State nextState (){
        return (new Finalizado(this.getPedido()));
    }

    @Override
    public String getState() {
        return "Finalizado";
    }

    @Override
    public boolean change() {
        return false;
    }
}