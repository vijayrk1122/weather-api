package com.assignment.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.weather.form.WeatherDetailsByZipcodeResponseForm;
import com.assignment.weather.service.WeatherService;
import com.assignments.utils.DateUtils;

@CrossOrigin
@RequestMapping("/weather-details")
@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/by-zipcode", method = RequestMethod.GET)
	public ResponseEntity<WeatherDetailsByZipcodeResponseForm> getWeatherDetailsByzipcode(
			@RequestParam(value = "zipCode", required = true) String zipCode){
		
		WeatherDetailsByZipcodeResponseForm responseForm = new WeatherDetailsByZipcodeResponseForm();		
		try {
			if(zipCode != null && zipCode != "" && zipCode.length() == 5) {
				responseForm.setData(weatherService.getWeatherDetailsByzipcode(zipCode));
				responseForm.setResponseCode(String.valueOf(HttpStatus.OK.value()));
				responseForm.setResponseMessage("SUCCESS");
				responseForm.setResponseCallTime(DateUtils.getCurrentTimestampInString());
				return new ResponseEntity<>(responseForm, HttpStatus.OK);
			} else {
				responseForm.setData(null);
				responseForm.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				responseForm.setResponseMessage("Enter valid ZipCode for US");
				responseForm.setResponseCallTime(DateUtils.getCurrentTimestampInString());
				return new ResponseEntity<>(responseForm, HttpStatus.BAD_REQUEST);
			}			
		} catch ( Exception e) {
			responseForm.setData(null);
			responseForm.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			responseForm.setResponseMessage(e.toString());
			responseForm.setResponseCallTime(DateUtils.getCurrentTimestampInString());
			return new ResponseEntity<>(responseForm, HttpStatus.BAD_REQUEST);
		}
	}	
}
