package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.PlatformTableRecord;
import io.krystof.nocodb.clients.RecordListing;

class PlatformTableClientIT {

	static PlatformTableClient client;

	private static final Logger LOG = LoggerFactory.getLogger(PlatformTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/PlatformTable";
		client = new PlatformTableClient(restTemplate, url);
	}


	void testGetAll() {
		RecordListing<PlatformTableRecord> recordListing = client.getAllRecords();

		LOG.info("{}", recordListing);

		recordListing.getList().forEach(record -> {
			LOG.info("Record: {}", record);
		});
	}

	void testLinks() {
		client.setLinkToGame(1, 2);
		client.setLinkToGame(2, 2);
		client.removeLinkToGame(1);
		client.setLinkToGame(1, 1);
	}
}