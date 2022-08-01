package io.krystof.nocodb.clients;

import java.util.ArrayList;
import java.util.List;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.krystof.nocodb.clients.serializers.S3StorageLinkDeSerializer;
import io.krystof.nocodb.clients.serializers.S3StorageLinkSerializer;

@JsonDeserialize(using = S3StorageLinkDeSerializer.class)
@JsonSerialize(using = S3StorageLinkSerializer.class)
@AutoProperty
public class S3StorageLinkList {

	List<S3StorageLink> links = new ArrayList<>();

	public List<S3StorageLink> getLinks() {
		return links;
	}

	public void setLinks(List<S3StorageLink> links) {
		this.links = links;
	}

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
}
