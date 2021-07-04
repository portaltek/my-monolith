package portaltek.mymonolith.spi.db.audit;

import org.springframework.data.domain.AuditorAware;


import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	@SuppressWarnings("NullableProblems")
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Logged User");
	}
}