package com.sample.connectionbuilder.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.connectionbuilder.model.FlightRequest;
import com.sample.connectionbuilder.model.FlightResponse;
import com.sample.connectionbuilder.service.ConnectorService;


@RestController
public class ConnectorController {

	@Autowired
	ConnectorService service;

	@PostMapping(path = "/getFlight", consumes = "application/json", produces = "application/json")
	public FlightResponse getFlightsBetween(@RequestBody FlightRequest request)
			throws ParseException {
		try {
			return service.getList(request.getDepAirport(), request.getArrAirport());
		} catch (ParseException e) {
			throw new ParseException("New ParseException", 500);
		}
	}
}
