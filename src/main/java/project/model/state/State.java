package project.model.state;

import project.model.Pedido;

import javax.persistence.*;

@Entity
@Table(name = "entity")
public abstract class State {

    @Id
    @OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public State(Pedido pedido)
    {
        this.pedido = pedido;
    }

    abstract public State nextState();
    abstract public String getState();
    abstract public boolean change();

}
