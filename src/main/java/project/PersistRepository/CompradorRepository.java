package project.PersistRepository;

import org.springframework.data.repository.CrudRepository;
import project.model.Comprador;

public interface CompradorRepository extends CrudRepository<Comprador,String> {

    Comprador findByCpf(String cpf);
}
