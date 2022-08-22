package io.krystof.nocodb.clients;

import java.util.List;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty("PortIdentifierTable")
	private IdAndTitleKey portIdentifierLinkRecord;

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

	@JsonProperty("Wikipedia URL")
	private String wikipediaUrl;

	@JsonProperty("Video URL")
	private String videoUrl;

	@JsonProperty("LaunchBox DB Notes")
	private String launchBoxDbNotes;

	@JsonProperty("My Box Art Image")
	private S3StorageLinkList myBoxArtImages;

	@JsonProperty("My Finished Status")
	private MyFinishedStatus myFinishedStatus;

	@JsonProperty("My Rating")
	private Integer myRating;

	@JsonProperty("My Notes")
	private String myNotes;

	@JsonProperty("My Death Count")
	private String myDeathCount;

	@JsonProperty("My Last Played")
	private String myLastPlayed;

	@JsonProperty("My High Score")
	private String myHighScore;

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

	public S3StorageLinkList getMyBoxArtImages() {
		return myBoxArtImages;
	}

	public void setMyBoxArtImages(S3StorageLinkList myBoxArtImages) {
		this.myBoxArtImages = myBoxArtImages;
	}

	public String getWikipediaUrl() {
		return wikipediaUrl;
	}

	public void setWikipediaUrl(String wikipediaUrl) {
		this.wikipediaUrl = wikipediaUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getMyDeathCount() {
		return myDeathCount;
	}

	public void setMyDeathCount(String myDeathCount) {
		this.myDeathCount = myDeathCount;
	}

	public String getMyLastPlayed() {
		return myLastPlayed;
	}

	public void setMyLastPlayed(String myLastPlayed) {
		this.myLastPlayed = myLastPlayed;
	}

	public String getMyHighScore() {
		return myHighScore;
	}

	public void setMyHighScore(String myHighScore) {
		this.myHighScore = myHighScore;
	}

	public IdAndTitleKey getPortIdentifierLinkRecord() {
		return portIdentifierLinkRecord;
	}

	public void setPortIdentifierLinkRecord(IdAndTitleKey portIdentifierLinkRecord) {
		this.portIdentifierLinkRecord = portIdentifierLinkRecord;
	}

}
