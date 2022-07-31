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

public class S3StorageLinkDeSerializer extends JsonDeserializer<List<S3StorageLink>> {

	@Override
	public List<S3StorageLink> deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JacksonException {
		String text = p.getText();
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		return mapper.readValue(text, new TypeReference<List<S3StorageLink>>() {
		});
	}

}
