package dad.javafx.geofx.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language {
	private String code;
	
	private String name;
	
	@JsonProperty("native")
	private String _native;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNative() {
		return _native;
	}

	public void setNative(String _native) {
		this._native = _native;
	}
	
}
