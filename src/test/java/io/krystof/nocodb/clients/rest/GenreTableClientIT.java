package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.GenreTableRecord;
import io.krystof.nocodb.clients.RecordListing;

class GenreTableClientIT {

	static GenreTableClient client;

	private static final Logger LOG = LoggerFactory.getLogger(GenreTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/GenreTable";
		client = new GenreTableClient(restTemplate, url);
	}

	@Test
	void testGetAll() {
		RecordListing<GenreTableRecord> recordListing = client.getAllRecords();

		LOG.info("{}", recordListing);

		recordListing.getList().forEach(record -> {
			LOG.info("Record: {}", record);
		});
	}

	void testLinks() {
		client.removeLinkToGame(1, 2);
		client.addLinkToGame(1, 2);
		client.removeLinkToGame(1, 2);
		client.addLinkToGame(1, 2);
	}
}