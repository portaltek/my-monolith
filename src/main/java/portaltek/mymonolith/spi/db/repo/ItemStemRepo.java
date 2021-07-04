package portaltek.mymonolith.spi.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portaltek.mymonolith.spi.db.model.ItemStem;


@Repository
public interface ItemStemRepo extends JpaRepository<ItemStem, String> {
}
