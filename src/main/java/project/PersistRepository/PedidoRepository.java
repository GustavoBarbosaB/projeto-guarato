package project.PersistRepository;

import org.springframework.data.repository.CrudRepository;
import project.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido,Integer>{

    Pedido findById(int id);
}
