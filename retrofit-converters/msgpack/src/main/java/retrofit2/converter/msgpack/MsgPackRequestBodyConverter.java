package retrofit2.converter.msgpack;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectWriter;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public class MsgPackRequestBodyConverter<T> implements Converter<T, RequestBody> {
	
	private static final MediaType MEDIA_TYPE = 
			MediaType.parse("application/octet-stream");

	private final ObjectWriter adapter;
	
	public MsgPackRequestBodyConverter(ObjectWriter adapter) {
		this.adapter = adapter;
	}
	
	@Override
	public RequestBody convert(T value) throws IOException {
		byte[] bytes = adapter.writeValueAsBytes(value);
		return RequestBody.create(MEDIA_TYPE, bytes);
	}

}
