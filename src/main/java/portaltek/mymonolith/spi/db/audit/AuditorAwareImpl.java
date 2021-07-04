package portaltek.mymonolith.spi.db.audit;

import org.springframework.data.domain.AuditorAware;


import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Logged User");
	}
}