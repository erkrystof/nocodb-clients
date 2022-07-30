package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

class GameTableClientIT {

	static GameTableClient gameTableClient;

	private static final Logger LOG = LoggerFactory.getLogger(GameTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/GameTable";
		gameTableClient = new GameTableClient(restTemplate, url);
	}

	@Test
	void test() {
		LOG.info("{}", gameTableClient.getAllRecords());
	}

}
