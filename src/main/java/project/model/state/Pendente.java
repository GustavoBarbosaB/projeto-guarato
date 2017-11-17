package project.model.state;

public class Pendente implements State {
    @Override
    public State nextState() {
        return new Finalizado();
    }

    public static State cancel(){
        return new Cancelado();
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