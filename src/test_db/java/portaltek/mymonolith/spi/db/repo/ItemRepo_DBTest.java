package portaltek.mymonolith.spi.db.repo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import portaltek.mymonolith.spi.db.DBTest;
import portaltek.mymonolith.spi.db.model.item.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DBTest
class ItemRepo_DBTest {

	@Autowired
	ItemRepo itemRepo;
	@Autowired
	ItemChoiceRepo itemChoiceRepo;

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
		item.stem(new ItemStem().item(item));
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
		item.stem(new ItemStem().item(item));
		item.addItemChoice(new ItemChoice().item(item));
		item.addItemChoice(new ItemChoice().item(item));

		itemRepo.saveAndFlush(item);
		final String persistedID = item.id();

		assertNotNull(persistedID);

		var itemOpt = itemRepo.loadById(persistedID);
		assertTrue(itemOpt.isPresent());

		var itemLoaded = itemOpt.get();
		itemLoaded.status(ItemStatus.IN_REVIEW);
		itemRepo.saveAndFlush(itemLoaded);

		var itemOpt2 = itemRepo.loadById(persistedID);
		assertTrue(itemOpt2.isPresent());
		var itemLoaded2 = itemOpt.get();

		assertEquals(ItemStatus.IN_REVIEW, itemLoaded2.status());
		assertNotNull(itemLoaded2.stem().id());
		assertEquals(2, itemLoaded2.choices().size());

		log.info(itemLoaded2.toString());

	}
}
