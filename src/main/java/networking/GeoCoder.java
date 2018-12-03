package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class GeoCoder {
	
	private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json?api_key=AIzaSyCrUHm5r5BKfLvNIP4HnH4X5IXNb0oh0dQ&";
	
	private Function<String,String> encoder = s ->{
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	};
	
	public String encodeAddress(List<String> address){
		return address.stream()
				.map(encoder)
				.collect(Collectors.joining(","));
		
	}
	
	public String getData(List<String> address){
		String encodded = encodeAddress(address);
		String response = "";
		
		try {
			URL url = new URL(String.format("%saddress=%s", BASE, encodded));
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))){
				String line = "";
				while((line = br.readLine()) != null){
					response += "\n" + line; 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public void fillInLatLng(Location location){
		String encoded = encodeAddress(Arrays.asList(location.getStreet(),location.getCity(),location.getState()));
		try {
			URL url = new URL(String.format("%saddress=%s",BASE,encoded));
			try(InputStream is = url.openStream();
					JsonReader jr = Json.createReader(is)){
				JsonObject jo = jr.readObject();
				JsonObject loc = jo.getJsonArray("results")
						.getJsonObject(0)
						.getJsonObject("geometry")
						.getJsonObject("location");
				location.setLatitude(loc.getJsonNumber("lat").doubleValue());
				location.setLongitude(loc.getJsonNumber("long").doubleValue());
				
			}catch(IOException e){
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
