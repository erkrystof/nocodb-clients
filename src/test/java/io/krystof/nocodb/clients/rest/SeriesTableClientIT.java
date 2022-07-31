package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.RecordListing;
import io.krystof.nocodb.clients.SeriesTableRecord;

class SeriesTableClientIT {

	static SeriesTableClient client;

	private static final Logger LOG = LoggerFactory.getLogger(SeriesTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/SeriesTable";
		client = new SeriesTableClient(restTemplate, url);
	}

	@Test
	void testGetAll() {
		RecordListing<SeriesTableRecord> recordListing = client.getAllRecords();

		LOG.info("{}", recordListing);

		recordListing.getList().forEach(record -> {
			LOG.info("Record: {}", record);
		});

	}
}