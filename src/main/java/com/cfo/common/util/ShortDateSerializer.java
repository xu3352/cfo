package com.cfo.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 短日期格式JSON日期:yyyy-MM-dd
 * @author xuyl
 * @date 2012-12-17
 */
public class ShortDateSerializer extends JsonSerializer<Date> {
	
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}
}