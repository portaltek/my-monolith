package portaltek.mymonolith.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wait {

	private Wait() {
	}

	public static void seconds(int seconds)  {
		try {
			log.info("Waiting {} second(s)...", seconds);
			long wait = seconds * 1000L;
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

	public static void minutes(int minutes) {
		try {
			log.info("Waiting {} minute(s)...", minutes);
			long wait = minutes * 60_000L;
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			Thread.currentThread().interrupt();
		}
	}
}
