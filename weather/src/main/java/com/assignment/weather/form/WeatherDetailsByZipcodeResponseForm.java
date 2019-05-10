package com.assignment.weather.form;

import java.util.List;

import com.assignment.weather.dto.HourlyTemperatureDto;

public class WeatherDetailsByZipcodeResponseForm {

	private String responseCode;
	private String responseMessage;
	private String responseCallTime;
	private List<HourlyTemperatureDto> data;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getResponseCallTime() {
		return responseCallTime;
	}
	public void setResponseCallTime(String responseCallTime) {
		this.responseCallTime = responseCallTime;
	}
	public List<HourlyTemperatureDto> getData() {
		return data;
	}
	public void setData(List<HourlyTemperatureDto> data) {
		this.data = data;
	}
	
	
	
}
