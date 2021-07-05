package portaltek.mymonolith.spi.db.repo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import portaltek.mymonolith.spi.db.DBTest;
import portaltek.mymonolith.spi.db.model.item.Item;
import portaltek.mymonolith.spi.db.model.item.ItemChoice;
import portaltek.mymonolith.spi.db.model.item.ItemStem;
import portaltek.mymonolith.spi.db.model.item.ItemType;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DBTest
class ItemRepo_DBTest {

	@Autowired
	ItemRepo itemRepo;
	@Autowired
	ItemChoiceRepo itemChoiceRepo;
	@Value("{spring.datasource.url}")
	String dbUrl;

	@Test
	void saveItem() {

		var item = new Item().type(ItemType.MC);
		itemRepo.save(item);
		itemRepo.flush();
		assertNotNull(item.id());

		var itemOpt = itemRepo.findById(item.id());
		assertTrue(itemOpt.isPresent());
		assertNotNull(itemOpt.get().id());

		log.info(itemOpt.get().toString());
	}

	@Test
	void saveItemWithStemAndChoices() {

		var item = new Item();
		item.setStem(new ItemStem().item(item));
		item.addItemChoice(new ItemChoice().item(item));
		item.addItemChoice(new ItemChoice().item(item));

		itemRepo.save(item);
		itemRepo.flush();
		assertNotNull(item.id());

		var itemOpt = itemRepo.findById(item.id());
		var itemChoicesList = itemChoiceRepo.findByItemId(item.id());
		assertTrue(itemOpt.isPresent());
		assertNotNull(itemOpt.get().stem().id());
		assertEquals(2, itemChoicesList.size());

		log.info(itemOpt.get().toString());

	}

	@Test
	void testLoadById() {

		var item = new Item();
		item.setStem(new ItemStem().item(item));
		item.addItemChoice(new ItemChoice().item(item));
		item.addItemChoice(new ItemChoice().item(item));

		itemRepo.save(item);
		itemRepo.flush();
		assertNotNull(item.id());

		var itemOpt = itemRepo.loadById(item.id());

		assertTrue(itemOpt.isPresent());
		assertNotNull(itemOpt.get().stem().id());
		assertEquals(2, itemOpt.get().choices().size());

		log.info(itemOpt.get().toString());

	}
}
