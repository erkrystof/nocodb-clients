package io.krystof.nocodb.clients;

import java.util.List;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

@AutoProperty
public class PlatformTableRecord {

	@JsonProperty("Id")
	private int id;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("GameTableLink")
	private List<IdAndTitleKey> gameTableLink;

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

	public List<IdAndTitleKey> getGameTableLink() {
		return gameTableLink;
	}

	public void setGameTableLink(List<IdAndTitleKey> gameTableLink) {
		this.gameTableLink = gameTableLink;
	}

}
