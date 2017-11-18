package project.model;

import project.model.item.ListItem;
import project.model.state.Iniciado;
import project.model.state.Pendente;
import project.model.state.State;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int comprador;
    private int vendedor;
    private List<ListItem> itens;
    private State state;

    protected Pedido()
    {
        state = new Iniciado();
    }

    public int getComprador() {
        return comprador;
    }

    public void setComprador(int  comprador) {
        this.comprador = comprador;
    }

    public int  getVendedor() {
        return vendedor;
    }

    public void setVendedor(int  vendedor) {
        this.vendedor = vendedor;
    }

    List<ListItem> getItems() {
        return itens;
    }

    public void setItems( List<ListItem> itens) {
        this.itens = itens;
    }

    public void cancel(){

        if(state instanceof Pendente)
            state = Pendente.cancel();
    }

    public void changeState(){
        state = state.nextState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
