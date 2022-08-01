package io.krystof.nocodb.clients.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.krystof.nocodb.clients.S3StorageLinkList;

/**
 * When we serialize this into Nocodb, it treats it as a string of json, not a
 * real object, so we convert it to a string first.
 * 
 * @author Eric R. Krystof
 *
 */
public class S3StorageLinkSerializer extends JsonSerializer<S3StorageLinkList> {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public void serialize(S3StorageLinkList value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {

		gen.writeObject(mapper.writeValueAsString(value.getLinks()));
	}

}
