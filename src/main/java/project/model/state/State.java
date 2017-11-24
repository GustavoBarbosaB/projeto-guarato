package project.model.state;

import project.model.Pedido;

import javax.persistence.*;
import java.io.Serializable;


public interface State {

     State nextState();
     String getState();
     boolean change();

}
