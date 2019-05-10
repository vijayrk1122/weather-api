package com.assignment.weather.dto;

/**
 * @author vijay.kumbhakarna
 *
 */
public class HourlyForecast {

	private ForecastLocation forecastLocation;

	public ForecastLocation getForecastLocation() {
		return forecastLocation;
	}

	public void setForecastLocation(ForecastLocation forecastLocation) {
		this.forecastLocation = forecastLocation;
	}
}
