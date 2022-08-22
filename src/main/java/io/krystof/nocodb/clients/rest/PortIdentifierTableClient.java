package io.krystof.nocodb.clients.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.krystof.nocodb.clients.PortIdentifierTableRecord;
import io.krystof.nocodb.clients.RecordListing;

public class PortIdentifierTableClient {

	private static final String DEFAULT_PAGE_SIZE = "25";

	private static final String DEFAULT_FIELDS = "Id,Title,GameTableLink";

	private static final String LINK_TO_GAME_APPEND = "/{portIdentifierId}/hm/GameTableLink/{gameId}";


	private static final ParameterizedTypeReference<RecordListing<PortIdentifierTableRecord>> LISTING_TYPE_REFERENCE = new ParameterizedTypeReference<RecordListing<PortIdentifierTableRecord>>() {
	};

	public PortIdentifierTableClient(RestTemplate restTemplate, String url) {
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

	public PortIdentifierTableRecord add(PortIdentifierTableRecord newRecord) {
		HttpEntity<PortIdentifierTableRecord> requestEntity = new HttpEntity<PortIdentifierTableRecord>(newRecord);
		return restTemplate.postForEntity(url, requestEntity, PortIdentifierTableRecord.class).getBody();
	}

	public RecordListing<PortIdentifierTableRecord> getAllRecords() {
		RecordListing<PortIdentifierTableRecord> summationListing = new RecordListing<>();
		HttpEntity<String> requestEntity = new HttpEntity<String>("");

		boolean moreRecords = true;
		int currentOffSet = 0;

		while (moreRecords) {

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("limit", PortIdentifierTableClient.DEFAULT_PAGE_SIZE)
					.queryParam("offset", Integer.toString(currentOffSet)).queryParam("fields", DEFAULT_FIELDS);
			ResponseEntity<RecordListing<PortIdentifierTableRecord>> response = restTemplate.exchange(
					builder.build().toUri(),
					HttpMethod.GET, requestEntity,
					LISTING_TYPE_REFERENCE);

			RecordListing<PortIdentifierTableRecord> myListing = response.getBody();

			summationListing.getList().addAll(myListing.getList());

			moreRecords = !myListing.getPageInfo().getIsLastPage();

			currentOffSet += myListing.getPageInfo().getPageSize();
		}

		return summationListing;
	}

	public void setLinkToGame(int portIdentifierId, int gameId) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.postForEntity(
				builder.buildAndExpand(Integer.toString(portIdentifierId), Integer.toString(gameId)).toUri(),
				requestEntity, String.class);
	}

	public void removeLinkToGame(int gameId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path(LINK_TO_GAME_APPEND);
		restTemplate.delete(builder.buildAndExpand("0", Integer.toString(gameId)).toUri());
	}

}
