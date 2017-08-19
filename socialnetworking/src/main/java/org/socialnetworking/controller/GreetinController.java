package org.socialnetworking.controller;

import org.socialnetworking.model.DomainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetinController {

	@RequestMapping(value = "/greeting")
	public ResponseEntity<DomainResponse> greeting() {
		return new ResponseEntity<DomainResponse>(new DomainResponse("Welcome from Spring RestController", 200),
				HttpStatus.OK);
	}
}
