package com.assignments.utils;

public enum ConstantVariables {

	WEATHER_API_URL("https://weather.cit.api.here.com/weather/1.0/report.json?product=forecast_hourly&oneobservation=true&app_id=DemoAppId01082013GAL&app_code=AJKnXv84fjrb0KIHawS0Tg&zipcode="),
	CONTENT_TYPE("application/json");
	
	private String value;
	
	public String getValue() {
		return this.value;
	}
	
	private ConstantVariables(String value) {
		this.value = value;
	}
}
