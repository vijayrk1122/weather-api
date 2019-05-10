package com.assignment.weather.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.assignment.weather.dto.ForecastDto;
import com.assignment.weather.dto.HourlyTemperatureDto;
import com.assignment.weather.dto.WeatherResponseDto;
import com.assignments.utils.DateUtils;

/**
 * @author vijay.kumbhakarna
 *
 */
@Component
public class WeatherMapper {

	/**
	 * @param dto
	 * @return list of HourlyTemperatureDto
	 */
	public List<HourlyTemperatureDto> MapWeatherDetailsByzipcode(WeatherResponseDto dto) {
		
		List<ForecastDto> hourlyDetails = new ArrayList<ForecastDto>();
		List<HourlyTemperatureDto>  list = new ArrayList<>();
		for(ForecastDto singleDto : dto.getHourlyForecasts().getForecastLocation().getForecast()) {
			if(singleDto.getWeekday().equals(DateUtils.nextDayOfWeek())) {
				hourlyDetails.add(singleDto);
			}
		}
		
		if(!hourlyDetails.isEmpty()) {
			for(ForecastDto singleForecast : hourlyDetails) {
				HourlyTemperatureDto hourlyTemperatureDto = new HourlyTemperatureDto();
				hourlyTemperatureDto.setHour(singleForecast.getLocalTime().length() > 2 ? singleForecast.getLocalTime().substring(0, 2) : null);
				hourlyTemperatureDto.setTemperature(singleForecast.getTemperature() != null ? singleForecast.getTemperature() : null);
				hourlyTemperatureDto.setTemperatureDesc(singleForecast.getTemperatureDesc() != null ? singleForecast.getTemperatureDesc() : null);
				list.add(hourlyTemperatureDto);
			}
		}		
		return list;
	}
}
