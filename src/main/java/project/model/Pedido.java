package project.model;

import project.model.state.Iniciado;
import project.model.state.Pendente;
import project.model.state.State;

import java.util.List;
import java.util.Map;

public class Pedido {

    private int comprador;
    private int vendedor;
    Map<Integer,Integer> items; // <item,quantidade>
    private State state;

    public Pedido()
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

    Map<Integer,Integer> getItems() {
        return items;
    }

    public void setItems( Map<Integer,Integer> items) {
        this.items = items;
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
