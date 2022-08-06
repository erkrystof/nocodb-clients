package io.krystof.nocodb.clients.rest;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.krystof.nocodb.clients.DeveloperTableRecord;
import io.krystof.nocodb.clients.RecordListing;

class DeveloperTableClientIT {

	static DeveloperTableClient client;

	private static final Logger LOG = LoggerFactory.getLogger(DeveloperTableClientIT.class);

	@BeforeAll
	public static void init() {
		RestTemplate restTemplate = TestMother.generateRestTemplate();
		String url = "https://" + System.getProperty("NocoDbHost") + "/api/v1/db/data/noco/BucketList/DeveloperTable";
		client = new DeveloperTableClient(restTemplate, url);
	}


	void testGetAll() {
		RecordListing<DeveloperTableRecord> recordListing = client.getAllRecords();

		LOG.info("{}", recordListing);

		recordListing.getList().forEach(record -> {
			LOG.info("Record: {}", record);
		});

	}
}