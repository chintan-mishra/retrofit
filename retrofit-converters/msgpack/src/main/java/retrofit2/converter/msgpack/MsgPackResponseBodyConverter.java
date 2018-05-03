package retrofit2.converter.msgpack;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class MsgPackResponseBodyConverter<T> implements Converter<ResponseBody, T>{
	
	private final ObjectReader adapter;
	
	public MsgPackResponseBodyConverter(ObjectReader adapter) {
		this.adapter = adapter;
	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		try {
			return adapter.readValue(value.charStream());
		} finally {
			value.close();
		}
	}

}
