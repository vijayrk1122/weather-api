package com.assignment.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.assignment.weather.dto.HourlyTemperatureDto;
import com.assignment.weather.dto.WeatherResponseDto;
import com.assignment.weather.mapper.WeatherMapper;
import com.assignments.utils.ConstantVariables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherMapper weatherMapper;

	public List<HourlyTemperatureDto> getWeatherDetailsByzipcode(String zipCode) throws Exception {
		ResponseEntity<String> responseInString = null;
		RestTemplate restTemplate = new RestTemplate();
		String uri = ConstantVariables.WEATHER_API_URL.getValue()+zipCode;		
		responseInString = restTemplate.getForEntity(uri, String.class);		
		Gson gson = new GsonBuilder().create();
		WeatherResponseDto response = gson.fromJson(responseInString.getBody(), WeatherResponseDto.class);
		return weatherMapper.MapWeatherDetailsByzipcode(response);		
	}
}
