package com.pronoydas.utility;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	
	//private final ObjectMapper mapper = new ObjectMapper();
	
	
	
	public static <T> T readJson(String path, Class<T> c) {
		ObjectMapper om = new ObjectMapper();
			
		try(InputStream stream = ResourceLoader.getResouce(path)){
			return om.readValue(stream, c);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	

}
}
