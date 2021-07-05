package portaltek.mymonolith.spi.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import portaltek.mymonolith.spi.db.model.item.Item;


import java.util.Optional;


@Repository
public interface ItemRepo extends JpaRepository<Item, String> {

	@Query(name = "Item.loadById")
	Optional<Item> loadById(String id);
}
