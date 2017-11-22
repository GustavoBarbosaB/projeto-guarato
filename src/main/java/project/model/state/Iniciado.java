package project.model.state;


import project.model.Pedido;

public class Iniciado extends State{

    public Iniciado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public State nextState() {
        return new Pendente(this.getPedido());
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
