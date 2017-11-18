package project.DBRepository;

import org.springframework.data.repository.CrudRepository;
import project.model.Pedido;

import java.util.List;

public interface PedidoRepository extends CrudRepository<Pedido,String>{

    List<Pedido> findById(int id);
}
