package io.krystof.nocodb.clients.serializers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.krystof.nocodb.clients.S3StorageLink;
import io.krystof.nocodb.clients.S3StorageLinkList;

public class S3StorageLinkDeSerializer extends JsonDeserializer<S3StorageLinkList> {

	@Override
	public S3StorageLinkList deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JacksonException {

		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		List<S3StorageLink> items = mapper.readValue(p, new TypeReference<List<S3StorageLink>>() {
		});
		S3StorageLinkList list = new S3StorageLinkList();
		list.getLinks().addAll(items);
		return list;
	}

}
