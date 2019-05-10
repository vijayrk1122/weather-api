package com.assignment.weather.dto;

public class WeatherResponseDto {

	private HourlyForecast hourlyForecasts;
	private String feedCreation;
	private Boolean metric;
	
	public HourlyForecast getHourlyForecasts() {
		return hourlyForecasts;
	}
	public void setHourlyForecasts(HourlyForecast hourlyForecasts) {
		this.hourlyForecasts = hourlyForecasts;
	}
	public String getFeedCreation() {
		return feedCreation;
	}
	public void setFeedCreation(String feedCreation) {
		this.feedCreation = feedCreation;
	}
	public Boolean getMetric() {
		return metric;
	}
	public void setMetric(Boolean metric) {
		this.metric = metric;
	}
}
