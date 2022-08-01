package io.krystof.nocodb.clients;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

@AutoProperty
public class GameTableFlatRecord {

	@JsonProperty("Id")
	private int id;

	@JsonProperty("My Box Art Image")
	private String boxArtUrl;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Platform")
	private String platform;

	@JsonProperty("Series")
	private String series;

	@JsonProperty("Series Index")
	private Integer seriesIndex;

	@JsonProperty("Series With Index")
	private String seriesWithIndex;

	@JsonProperty("Genres")
	private String genres;

	@JsonProperty("Publishers")
	private String publishers;

	@JsonProperty("Developers")
	private String developers;

	@JsonProperty("LaunchBox Database Id")
	private String launchBoxDatabaseId;

	@JsonProperty("Release Year")
	private Integer releaseYear;

	@JsonProperty("LaunchBox DB Notes")
	private String launchBoxDbNotes;

	@JsonProperty("My Finished Status")
	private String myFinishedStatus;

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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
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

	public String getBoxArtUrl() {
		return boxArtUrl;
	}

	public void setBoxArtUrl(String boxArtUrl) {
		this.boxArtUrl = boxArtUrl;
	}

	public String getMyFinishedStatus() {
		return myFinishedStatus;
	}

	public void setMyFinishedStatus(String myFinishedStatus) {
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

	public String getSeriesWithIndex() {
		return seriesWithIndex;
	}

	public void setSeriesWithIndex(String seriesWithIndex) {
		this.seriesWithIndex = seriesWithIndex;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Integer getSeriesIndex() {
		return seriesIndex;
	}

	public void setSeriesIndex(Integer seriesIndex) {
		this.seriesIndex = seriesIndex;
	}

}
