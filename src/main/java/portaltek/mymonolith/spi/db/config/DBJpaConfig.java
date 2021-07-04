package portaltek.mymonolith.spi.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import portaltek.mymonolith.spi.db.audit.AuditorAwareImpl;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class DBJpaConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}