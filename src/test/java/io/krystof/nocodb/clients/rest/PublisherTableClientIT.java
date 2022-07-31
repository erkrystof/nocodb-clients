package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.PublisherTableRecord;
import io.krystof.nocodb.clients.RecordListing;

class PublisherTableClientIT {

	static PublisherTableClient client;

	private static final Logger LOG = LoggerFactory.getLogger(PublisherTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/PublisherTable";
		client = new PublisherTableClient(restTemplate, url);
	}

	@Test
	void testGetAll() {
		RecordListing<PublisherTableRecord> recordListing = client.getAllRecords();

		LOG.info("{}", recordListing);

		recordListing.getList().forEach(record -> {
			LOG.info("Record: {}", record);
		});

	}
}