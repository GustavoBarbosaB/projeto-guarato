package project.PersistRepository;

import org.springframework.data.repository.CrudRepository;
import project.model.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor,String> {

        Vendedor findById(String cnpj);
}
