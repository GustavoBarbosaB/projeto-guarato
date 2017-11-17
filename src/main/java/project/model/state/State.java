package project.model.state;

public interface State {

    State nextState();
    String getState();
    boolean change();

}
