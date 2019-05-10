package com.assignment.weather.dto;

import java.util.List;

/**
 * @author vijay.kumbhakarna
 *
 */
public class ForecastLocation {

	private List<ForecastDto> forecast;
	private String country;
	private String state;
	private String city;
	private String latitude;
	private String longitude;
	private String distance;
	private Integer timezone;
	
	public List<ForecastDto> getForecast() {
		return forecast;
	}
	public void setForecast(List<ForecastDto> forecast) {
		this.forecast = forecast;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public Integer getTimezone() {
		return timezone;
	}
	public void setTimezone(Integer timezone) {
		this.timezone = timezone;
	}	
}
