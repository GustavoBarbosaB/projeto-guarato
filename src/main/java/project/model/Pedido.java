package project.model;

import project.model.item.ItemPedido;
import project.model.state.Iniciado;
import project.model.state.Pendente;
import project.model.state.State;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pedido")
public class Pedido {

    public int getId() {
        return id;
    }

    /**
     * Estamos gerando o ID automaticamente através do próprio JPA
     * A anotação @OneToOne faz com essa relação entre pedido e comprador e
     * pedido e vendedor seja de "um para um". O Cascade usado é somente para
     * dar o MERGE nas alterações nos objetos, não aceitando por exemplo
     * REMOVE, PERSIST, REFRESH, DETACH, que são outras ações possíveis no
     * método cascade.
     */

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_pedido")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Comprador comprador;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Vendedor vendedor;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    @OneToOne
    private State state;


    //--------------------------------------------------------------------------------------------------------------------/


    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    protected Pedido()
    {
        state = new Iniciado(this);
    }

    List<ItemPedido> getItems() {
        return itens;
    }

    public void setItems( List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void cancel(){

        if(state instanceof Pendente)
            state = Pendente.cancel(this);
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
