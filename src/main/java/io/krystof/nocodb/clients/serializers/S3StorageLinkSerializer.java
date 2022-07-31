package io.krystof.nocodb.clients.serializers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.krystof.nocodb.clients.S3StorageLink;

public class S3StorageLinkSerializer extends JsonSerializer<List<S3StorageLink>> {

	@Override
	public void serialize(List<S3StorageLink> value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {
		gen.writeObject(value);
	}

}
