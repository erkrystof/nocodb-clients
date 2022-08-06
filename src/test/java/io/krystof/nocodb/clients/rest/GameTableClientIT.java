package io.krystof.nocodb.clients.rest;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.GameTableFlatRecord;
import io.krystof.nocodb.clients.GameTableRecord;
import io.krystof.nocodb.clients.RecordListing;

class GameTableClientIT {

	static GameTableClient gameTableClient;

	private static final Logger LOG = LoggerFactory.getLogger(GameTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/GameTable";
		gameTableClient = new GameTableClient(restTemplate, url);
	}


	void testGetAll() {
		RecordListing<GameTableRecord> gameTableRecordListing = gameTableClient.getAllRecords();

		LOG.info("{}", gameTableRecordListing);

		gameTableRecordListing.getList().forEach(game -> {
			LOG.info("Game: {}", game);
		});

	}


	void testGetAllFlat() {
		List<GameTableFlatRecord> gameTableRecordListing = gameTableClient.getAllFlatRecords();

		LOG.info("{}", gameTableRecordListing);

		gameTableRecordListing.forEach(game -> {
			LOG.info("Game: {}", game.getTitle());
		});

	}

	void testGetByTitleAndPlatform() {
		RecordListing<GameTableRecord> gameTitleAndPlatform = gameTableClient.getGameTableRecordByTitleAndPlatformId("Some Game Part 1",
				1);

		LOG.info("{}", gameTitleAndPlatform);

	}

	void testAddRemove() {
		GameTableRecord testRecord = new GameTableRecord();
		testRecord.setTitle("TEST GAME DELETE ME");
		testRecord = gameTableClient.add(testRecord);
		LOG.info("Added: {}", testRecord);
		int idOfTestRecordAdded = testRecord.getId();
//		gameTableClient.deleteById(idOfTestRecordAdded);

	}

}
