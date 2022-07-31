package io.krystof.nocodb.clients.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.krystof.nocodb.clients.PublisherTableRecord;
import io.krystof.nocodb.clients.RecordListing;

public class PublisherTableClient {

	private static final String DEFAULT_PAGE_SIZE = "25";

	private static final String DEFAULT_FIELDS = "Id,Title,GameTableLinks";

	private static final String LINK_TO_GAME_APPEND = "/{publisherId}/mm/GameTableLinks/{gameId}";

	private static final ParameterizedTypeReference<RecordListing<PublisherTableRecord>> LISTING_TYPE_REFERENCE = new ParameterizedTypeReference<RecordListing<PublisherTableRecord>>() {
	};

	public PublisherTableClient(RestTemplate restTemplate, String url) {
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

	public PublisherTableRecord add(PublisherTableRecord newRecord) {
		HttpEntity<PublisherTableRecord> requestEntity = new HttpEntity<PublisherTableRecord>(newRecord);
		return restTemplate.postForEntity(url, requestEntity, PublisherTableRecord.class).getBody();
	}

	public RecordListing<PublisherTableRecord> getAllRecords() {
		RecordListing<PublisherTableRecord> summationListing = new RecordListing<>();
		HttpEntity<String> requestEntity = new HttpEntity<String>("");

		boolean moreRecords = true;
		int currentOffSet = 0;

		while (moreRecords) {

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("limit", PublisherTableClient.DEFAULT_PAGE_SIZE)
					.queryParam("offset", Integer.toString(currentOffSet)).queryParam("fields", DEFAULT_FIELDS);
			ResponseEntity<RecordListing<PublisherTableRecord>> response = restTemplate.exchange(
					builder.build().toUri(),
					HttpMethod.GET, requestEntity,
					LISTING_TYPE_REFERENCE);

			RecordListing<PublisherTableRecord> myListing = response.getBody();

			summationListing.getList().addAll(myListing.getList());

			moreRecords = !myListing.getPageInfo().getIsLastPage();

			currentOffSet += myListing.getPageInfo().getPageSize();
		}

		return summationListing;
	}

	public void addLinkToGame(int pubId, int gameId) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.postForEntity(builder.buildAndExpand(Integer.toString(pubId), Integer.toString(gameId)).toUri(),
				requestEntity, String.class);
	}

	public void removeLinkToGame(int pubId, int gameId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.delete(builder.buildAndExpand(Integer.toString(pubId), Integer.toString(gameId)).toUri());
	}
}
