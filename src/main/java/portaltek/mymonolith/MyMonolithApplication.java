package portaltek.mymonolith;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import portaltek.mymonolith.spi.db.model.item.Item;
import portaltek.mymonolith.spi.db.model.item.ItemChoice;
import portaltek.mymonolith.spi.db.model.item.ItemStem;
import portaltek.mymonolith.spi.db.model.item.ItemType;
import portaltek.mymonolith.spi.db.repo.ItemRepo;

import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class MyMonolithApplication implements CommandLineRunner {


	@Autowired
	ItemRepo itemRepo;

	@Override
	public void run(String... args) {

		var item = new Item().type(ItemType.MC);
		item.stem(new ItemStem().item(item))
			.addItemChoice(new ItemChoice().item(item))
			.addItemChoice(new ItemChoice().item(item));

		itemRepo.save(item);
		log.info(item.toString());

	}

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(MyMonolithApplication.class, args);
	}

}
