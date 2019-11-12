package dad.javafx.geofx.ipclient;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dad.javafx.geofx.ipclient.UnirestObjectMapper;
import dad.javafx.geofx.messages.IPMessage;

public class IPService {
	public IPService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}
	public String getIP() throws IPServiceException {
		try {
			IPMessage ip =
					Unirest
					.get("https://api.ipify.org/?format=json")
					.asObject(IPMessage.class)
					.getBody();
			return ip.getIp();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			throw new IPServiceException();
		}
	}
}
