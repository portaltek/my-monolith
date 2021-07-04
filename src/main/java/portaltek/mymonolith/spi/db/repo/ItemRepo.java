package portaltek.mymonolith.spi.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portaltek.mymonolith.spi.db.model.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item, String> {
}
