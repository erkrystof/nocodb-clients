package io.krystof.nocodb.clients.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.krystof.nocodb.clients.GameTableRecord;
import io.krystof.nocodb.clients.RecordListing;
import io.krystof.nocodb.clients.exceptions.UnexpectedMultipleRowsException;

public class GameTableClient {

	private static final String DEFAULT_PAGE_SIZE = "25";

	private static final String DEFAULT_FIELDS = "Id,Title,My Box Art Image,My Rating,Series Index,LaunchBoxDatabase Id,Release Year,My Finished Status,LaunchBox Database Id,LaunchBox DB Notes,My Notes,PlatformTable,SeriesTable,PublisherTable List,DeveloperTable List,GenreTable List";

	private static final ParameterizedTypeReference<RecordListing<GameTableRecord>> LISTING_TYPE_REFERENCE=new ParameterizedTypeReference<RecordListing<GameTableRecord>>(){};

	public GameTableClient(RestTemplate restTemplate, String url) {
		super();
		this.restTemplate = restTemplate;
		this.url = url;
	}

	private RestTemplate restTemplate;

	private String url;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void deleteById(int id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path("/{id}");
		restTemplate.delete(builder.buildAndExpand(Integer.toString(id)).toUri());
	}

	public GameTableRecord add(GameTableRecord gameTableRecord) {
		HttpEntity<GameTableRecord> requestEntity = new HttpEntity<GameTableRecord>(gameTableRecord);
		return restTemplate.postForEntity(url, requestEntity, GameTableRecord.class).getBody();
	}

	/**
	 * Not a real primary key via the rest api, but we use this to see if the record
	 * exists. If we detect more than one record we throw an exception.
	 */
	public RecordListing<GameTableRecord> getGameTableRecord(String title, int platformId) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("limit", GameTableClient.DEFAULT_PAGE_SIZE)
				.queryParam("fields", DEFAULT_FIELDS)
				.queryParam("where", String.format("(Title,eq,%s)~and(PlatformTable_id,eq,%d)", title, platformId));

		ResponseEntity<RecordListing<GameTableRecord>> response = restTemplate.exchange(builder.build().toUri(),
				HttpMethod.GET, requestEntity,
				LISTING_TYPE_REFERENCE);

		if (response.getBody().getPageInfo().getTotalRows() > 1) {
			throw new UnexpectedMultipleRowsException(
					String.format("Found multiple rows for title %s and platform id %d", title, platformId));
		}
		return response.getBody();
	}

	public RecordListing<GameTableRecord> getAllRecords() {
		RecordListing<GameTableRecord> summationListing = new RecordListing<GameTableRecord>();
		HttpEntity<String> requestEntity = new HttpEntity<String>("");

		boolean moreRecords = true;
		int currentOffSet = 0;

		while (moreRecords) {

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("limit", GameTableClient.DEFAULT_PAGE_SIZE)
					.queryParam("offset", Integer.toString(currentOffSet)).queryParam("fields", DEFAULT_FIELDS);
			ResponseEntity<RecordListing<GameTableRecord>> response = restTemplate.exchange(builder.build().toUri(),
					HttpMethod.GET, requestEntity,
					LISTING_TYPE_REFERENCE);

			RecordListing<GameTableRecord> myListing = response.getBody();

			summationListing.getList().addAll(myListing.getList());

			moreRecords = !myListing.getPageInfo().getIsLastPage();

			currentOffSet += myListing.getPageInfo().getPageSize();
		}

		return summationListing;
	}

}
