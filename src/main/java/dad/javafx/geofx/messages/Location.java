package dad.javafx.geofx.messages;

public class Location {
	private long geoname_id;
	private String capital;
	private Language[] languages;
	private String country_flag;
	private String country_flag_emoji;
	private String country_flag_emoji_unicode;
	private String calling_code;
	private Boolean is_eu;
	public long getGeoname_id() {
		return geoname_id;
	}
	public void setGeoname_id(long geoname_id) {
		this.geoname_id = geoname_id;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Language[] getLanguages() {
		return languages;
	}
	public void setLanguages(Language[] languages) {
		this.languages = languages;
	}
	public String getCountry_flag() {
		return country_flag;
	}
	public void setCountry_flag(String country_flag) {
		this.country_flag = country_flag;
	}
	public String getCountry_flag_emoji() {
		return country_flag_emoji;
	}
	public void setCountry_flag_emoji(String country_flag_emoji) {
		this.country_flag_emoji = country_flag_emoji;
	}
	public String getCountry_flag_emoji_unicode() {
		return country_flag_emoji_unicode;
	}
	public void setCountry_flag_emoji_unicode(String country_flag_emoji_unicode) {
		this.country_flag_emoji_unicode = country_flag_emoji_unicode;
	}
	public String getCalling_code() {
		return calling_code;
	}
	public void setCalling_code(String calling_code) {
		this.calling_code = calling_code;
	}
	public Boolean getIs_eu() {
		return is_eu;
	}
	public void setIs_eu(Boolean is_eu) {
		this.is_eu = is_eu;
	}
	
}
