package portaltek.mymonolith.spi.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portaltek.mymonolith.spi.db.model.ItemChoice;

import java.util.List;


@Repository
public interface ItemChoiceRepo extends JpaRepository<ItemChoice, String> {

	List<ItemChoice> findByItemId(String id);

}
