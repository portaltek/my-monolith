package portaltek.mymonolith;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class MyMonolithApplicationTests {

	static Properties prop = new Properties();
	static String PROP_FILE = "src/test/resources/application.properties";


	@BeforeAll
	static void init() throws IOException {
		prop.load(new FileReader(PROP_FILE));
		prop.forEach((k, v) -> setProperty(String.valueOf(k), String.valueOf(v)));
	}

	@Test
	void test() {
		String appHi = prop.get("app.hi").toString();
		log.info(appHi);
		assertNotNull(appHi);
	}

	@Test
	void test2() {
		String appHi = getProperty("app.hi");
		log.info(appHi);
		assertNotNull(appHi);
	}



}
