package com.assignment.weather.dto;


/**
 * @author vijay.kumbhakarna
 *
 */
public class HourlyTemperatureDto {
	
	private String hour;
	private String temperature;
	private String temperatureDesc;
	
	public HourlyTemperatureDto(String hour, String temperature, String temperatureDesc) {
		this.hour = hour;
		this.temperature = temperature;
		this.temperatureDesc = temperatureDesc;
	}
	
	public HourlyTemperatureDto() {
	}
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureDesc() {
		return temperatureDesc;
	}
	public void setTemperatureDesc(String temperatureDesc) {
		this.temperatureDesc = temperatureDesc;
	}	
}
