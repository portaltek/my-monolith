package portaltek.mymonolith.spi.db;


import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;

import static java.lang.System.setProperty;
import static java.util.Objects.nonNull;

public class SpiPostgresTestExtension implements BeforeAllCallback {

	private final static String DOCKER_IMAGE = "postgres:13.3-alpine";
	private final static String DB_USERNAME = "postgres";
	private final static String DB_PASSWORD = "postgres";
	private final static String DB_DRIVER = "org.postgresql.Driver";
	private final static String DB_NAME = "myPostgresDB";
	private final static int DB_PORT = 5432;

	private static PostgreSQLContainer<?> container;

	@Override
	public void beforeAll(ExtensionContext context) {
		if (nonNull(container)) return;

		container = new PostgreSQLContainer<>(DOCKER_IMAGE)
			.withDatabaseName(DB_NAME)
			.withUsername(DB_USERNAME)
			.withPassword(DB_PASSWORD)
			.withExposedPorts(DB_PORT)
			.withReuse(true);

		container.start();

		setProperty("spring.datasource.url", container.getJdbcUrl());
		setProperty("spring.datasource.username", DB_USERNAME);
		setProperty("spring.datasource.password", DB_PASSWORD);
		setProperty("spring.datasource.driverClassName", DB_DRIVER);
		setProperty("spring.jpa.hibernate.ddl-auto", "update");
		setProperty("spring.jpa.hibernate.show_sql", "true");

	}


}
