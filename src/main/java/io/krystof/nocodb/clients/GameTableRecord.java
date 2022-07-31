package io.krystof.nocodb.clients;

import java.util.List;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.krystof.nocodb.clients.serializers.S3StorageLinkDeSerializer;
import io.krystof.nocodb.clients.serializers.S3StorageLinkSerializer;

@AutoProperty
public class GameTableRecord {

	@JsonProperty("Id")
	private int id;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("PlatformTable")
	private IdAndTitleKey platformTableLinkRecord;

	@JsonProperty("SeriesTable")
	private IdAndTitleKey seriesTableLinkRecord;

	@JsonProperty("Series Index")
	private Integer seriesIndex;

	@JsonProperty("GenreTable List")
	private List<IdAndTitleKey> idAndTitleKeies;

	@JsonProperty("PublisherTable List")
	private List<IdAndTitleKey> publisherTableListLinkRecords;

	@JsonProperty("DeveloperTable List")
	private List<IdAndTitleKey> developerTableListLinkRecords;

	@JsonProperty("LaunchBox Database Id")
	private String launchBoxDatabaseId;

	@JsonProperty("Release Year")
	private Integer releaseYear;

	@JsonProperty("LaunchBox DB Notes")
	private String launchBoxDbNotes;

//	private String myBoxArtImage;

	@JsonProperty("My Box Art Image")
	@JsonDeserialize(using = S3StorageLinkDeSerializer.class)
	@JsonSerialize(using = S3StorageLinkSerializer.class)
	private List<S3StorageLink> myBoxArtImages;

	@JsonProperty("My Finished Status")
	private MyFinishedStatus myFinishedStatus;

	@JsonProperty("My Rating")
	private Integer myRating;

	@JsonProperty("My Notes")
	private String myNotes;

	@Override
	public boolean equals(Object o) {
		return Pojomatic.equals(this, o);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSeriesIndex() {
		return seriesIndex;
	}

	public void setSeriesIndex(Integer seriesIndex) {
		this.seriesIndex = seriesIndex;
	}

	public String getLaunchBoxDatabaseId() {
		return launchBoxDatabaseId;
	}

	public void setLaunchBoxDatabaseId(String launchBoxDatabaseId) {
		this.launchBoxDatabaseId = launchBoxDatabaseId;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLaunchBoxDbNotes() {
		return launchBoxDbNotes;
	}

	public void setLaunchBoxDbNotes(String launchBoxDbNotes) {
		this.launchBoxDbNotes = launchBoxDbNotes;
	}

	public MyFinishedStatus getMyFinishedStatus() {
		return myFinishedStatus;
	}

	public void setMyFinishedStatus(MyFinishedStatus myFinishedStatus) {
		this.myFinishedStatus = myFinishedStatus;
	}

	public Integer getMyRating() {
		return myRating;
	}

	public void setMyRating(Integer myRating) {
		this.myRating = myRating;
	}

	public String getMyNotes() {
		return myNotes;
	}

	public void setMyNotes(String myNotes) {
		this.myNotes = myNotes;
	}

	public List<S3StorageLink> getMyBoxArtImages() {
		return myBoxArtImages;
	}

	public void setMyBoxArtImages(List<S3StorageLink> myBoxArtImages) {
		this.myBoxArtImages = myBoxArtImages;
	}

	public List<IdAndTitleKey> getGenreTableListLinkRecords() {
		return idAndTitleKeies;
	}

	public void setGenreTableListLinkRecords(List<IdAndTitleKey> idAndTitleKeies) {
		this.idAndTitleKeies = idAndTitleKeies;
	}

	public IdAndTitleKey getPlatformTableLinkRecord() {
		return platformTableLinkRecord;
	}

	public void setPlatformTableLinkRecord(IdAndTitleKey platformTableLinkRecord) {
		this.platformTableLinkRecord = platformTableLinkRecord;
	}

	public IdAndTitleKey getSeriesTableLinkRecord() {
		return seriesTableLinkRecord;
	}

	public void setSeriesTableLinkRecord(IdAndTitleKey seriesTableLinkRecord) {
		this.seriesTableLinkRecord = seriesTableLinkRecord;
	}

	public List<IdAndTitleKey> getIdAndTitleKeies() {
		return idAndTitleKeies;
	}

	public void setIdAndTitleKeies(List<IdAndTitleKey> idAndTitleKeies) {
		this.idAndTitleKeies = idAndTitleKeies;
	}

	public List<IdAndTitleKey> getPublisherTableListLinkRecords() {
		return publisherTableListLinkRecords;
	}

	public void setPublisherTableListLinkRecords(List<IdAndTitleKey> publisherTableListLinkRecords) {
		this.publisherTableListLinkRecords = publisherTableListLinkRecords;
	}

	public List<IdAndTitleKey> getDeveloperTableListLinkRecords() {
		return developerTableListLinkRecords;
	}

	public void setDeveloperTableListLinkRecords(List<IdAndTitleKey> developerTableListLinkRecords) {
		this.developerTableListLinkRecords = developerTableListLinkRecords;
	}

}
