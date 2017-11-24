package project.model.state;


import project.model.Pedido;

public class Iniciado implements State{

       @Override
    public State nextState() {
        return new Pendente();
    }

    @Override
    public String getState() {
        return "Iniciado";
    }

    @Override
    public boolean change() {
        return false;
    }
}
