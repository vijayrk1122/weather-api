package com.assignment.weather.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.weather.dto.HourlyTemperatureDto;
import com.assignment.weather.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WeatherService weatherService;
	
	@Test
	public void weatherService_getWeatherDetailsByzipcode() throws Exception{
		when(weatherService.getWeatherDetailsByzipcode("35801")).thenReturn(
				Arrays.asList(new HourlyTemperatureDto("00", "10.50", "Mild"),
						new HourlyTemperatureDto("01", "11.00", "Mild")));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/by-zipcode")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"responseCode\":\"200\",\"responseMessage\":\"SUCCESS\",\"responseCallTime\":\"2019-05-10 08:34:25.356\",\"data\":[{\"hour\":\"00\",\"temperature\":\"10.50\",\"temperatureDesc\":\"Mild\"},{\"hour\":\"01\",\"temperature\":\"11.00\",\"temperatureDesc\":\"Mild\"}]}"))
				.andReturn();
		
	}
}
