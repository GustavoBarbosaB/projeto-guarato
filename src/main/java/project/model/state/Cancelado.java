package project.model.state;

public class Cancelado implements State {

    @Override
    public State nextState() {
        return new Cancelado();
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