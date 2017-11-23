package project.model.state;

import project.model.Pedido;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "state")
public abstract class State implements Serializable {

    @Id
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
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
