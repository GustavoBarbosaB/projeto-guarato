package project.PersistRepository;

import org.springframework.data.repository.CrudRepository;
import project.model.item.Item;

public interface ItemRepository extends CrudRepository<Item,Integer> {

    Item findById(int id);
}
