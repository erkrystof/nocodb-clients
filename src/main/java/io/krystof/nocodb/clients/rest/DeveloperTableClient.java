package io.krystof.nocodb.clients.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.krystof.nocodb.clients.DeveloperTableRecord;
import io.krystof.nocodb.clients.RecordListing;

public class DeveloperTableClient {

	private static final String DEFAULT_PAGE_SIZE = "25";

	private static final String DEFAULT_FIELDS = "Id,Title,GameTableLinks";

	private static final String LINK_TO_GAME_APPEND = "/{developerId}/mm/GameTableLinks/{gameId}";

	private static final ParameterizedTypeReference<RecordListing<DeveloperTableRecord>> LISTING_TYPE_REFERENCE = new ParameterizedTypeReference<RecordListing<DeveloperTableRecord>>() {
	};

	public DeveloperTableClient(RestTemplate restTemplate, String url) {
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

	public DeveloperTableRecord add(DeveloperTableRecord newRecord) {
		HttpEntity<DeveloperTableRecord> requestEntity = new HttpEntity<DeveloperTableRecord>(newRecord);
		return restTemplate.postForEntity(url, requestEntity, DeveloperTableRecord.class).getBody();
	}

	public RecordListing<DeveloperTableRecord> getAllRecords() {
		RecordListing<DeveloperTableRecord> summationListing = new RecordListing<>();
		HttpEntity<String> requestEntity = new HttpEntity<String>("");

		boolean moreRecords = true;
		int currentOffSet = 0;

		while (moreRecords) {

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("limit", DeveloperTableClient.DEFAULT_PAGE_SIZE)
					.queryParam("offset", Integer.toString(currentOffSet)).queryParam("fields", DEFAULT_FIELDS);
			ResponseEntity<RecordListing<DeveloperTableRecord>> response = restTemplate.exchange(
					builder.build().toUri(),
					HttpMethod.GET, requestEntity,
					LISTING_TYPE_REFERENCE);

			RecordListing<DeveloperTableRecord> myListing = response.getBody();

			summationListing.getList().addAll(myListing.getList());

			moreRecords = !myListing.getPageInfo().getIsLastPage();

			currentOffSet += myListing.getPageInfo().getPageSize();
		}

		return summationListing;
	}

	public void addLinkToGame(int devId, int gameId) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.postForEntity(builder.buildAndExpand(Integer.toString(devId), Integer.toString(gameId)).toUri(),
				requestEntity, String.class);
	}

	public void removeLinkToGame(int devId, int gameId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.delete(builder.buildAndExpand(Integer.toString(devId), Integer.toString(gameId)).toUri());
	}
}
