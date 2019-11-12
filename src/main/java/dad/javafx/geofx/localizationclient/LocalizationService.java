package dad.javafx.geofx.localizationclient;



import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.geofx.ipclient.UnirestObjectMapper;
import dad.javafx.geofx.messages.RootMessage;

public class LocalizationService {
	public LocalizationService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}
	String ip;
	public RootMessage getData() throws GeoServiceException{
		
		try {
			RootMessage message =
					Unirest
					.get("http://api.ipapi.com/"+ip+"?access_key=bfd83f01cd57d2ae296f7b4928090312&format=1")
					.asObject(RootMessage.class)
					.getBody();
			return message;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			throw new GeoServiceException();
		}
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}

