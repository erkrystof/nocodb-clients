package io.krystof.nocodb.clients;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.pojomatic.annotations.AutoProperty;

@AutoProperty
/**
 * All fields here are optionals except for ID. If the inbound argument for a
 * field is null, we won't add it to the map. To wipe out a NocoDb field, pass
 * an empty Optional.
 */
public class GameTableRecordFieldMapBuilder {

	private Map<String, Object> map = new HashMap<>();

	public GameTableRecordFieldMapBuilder withReleaseYear(Optional<Integer> releaseYear) {
		if (releaseYear != null) {
			map.put("Release Year", releaseYear.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withMyFinishedStatus(Optional<MyFinishedStatus> myFinishedStatus) {
		if (myFinishedStatus != null) {
			map.put("My Finished Status", myFinishedStatus.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withSeriesIndex(Optional<Integer> seriesIndex) {
		if (seriesIndex != null) {
			map.put("Series Index", seriesIndex.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withLaunchBoxDatabaseId(Optional<String> launchBoxDatabaseId) {
		if (launchBoxDatabaseId != null) {
			map.put("LaunchBox Database Id", launchBoxDatabaseId.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withWikipediaUrl(Optional<String> wikipediaUrl) {
		if (wikipediaUrl != null) {
			map.put("Wikipedia URL", wikipediaUrl.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withVideoUrl(Optional<String> videoUrl) {
		if (videoUrl != null) {
			map.put("Video URL", videoUrl.orElse(null));
		}
		return this;
	}
	public GameTableRecordFieldMapBuilder withLaunchBoxDatabaseNotes(Optional<String> launchBoxDbNotes) {
		if (launchBoxDbNotes != null) {
			map.put("LaunchBox DB Notes", launchBoxDbNotes.orElse(null));
		}
		return this;
	}

	public GameTableRecordFieldMapBuilder withBoxArtImages(Optional<S3StorageLinkList> myBoxArtImages) {
		if (myBoxArtImages != null) {
			map.put("My Box Art Image", myBoxArtImages.orElse(null));
		}
		return this;
	}

	public Map<String, Object> build() {
		return map;
	}

}
