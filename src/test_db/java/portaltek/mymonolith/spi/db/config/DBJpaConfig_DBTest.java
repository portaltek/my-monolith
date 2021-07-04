package portaltek.mymonolith.spi.db.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import portaltek.mymonolith.spi.db.DBTest;


import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DBTest
class DBJpaConfig_DBTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private EntityManager entityManager;


	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(entityManager).isNotNull();
	}
}