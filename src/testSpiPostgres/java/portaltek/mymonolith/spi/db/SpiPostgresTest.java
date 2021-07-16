package portaltek.mymonolith.spi.db;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@ExtendWith(SpiPostgresTestExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpiPostgresTest {

}
