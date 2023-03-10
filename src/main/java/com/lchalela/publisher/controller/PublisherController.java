package com.lchalela.publisher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lchalela.publisher.dto.TransactionDTO;
import com.lchalela.publisher.service.PublisherService;

@RestController
@RequestMapping("/v1")
public class PublisherController {

	private Logger logger = LoggerFactory.getLogger(PublisherController.class);
	
	@Autowired
	private PublisherService publisherService;

	@PostMapping("/new")
	public ResponseEntity<Object> createMessage(@RequestBody TransactionDTO transaction) {
		logger.info("Init request create message");
		String message = this.publisherService.sendMessage(transaction);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@PostMapping("/send-email")
	public ResponseEntity<Object> createMessage(@RequestBody String message){
		String email = this.publisherService.sendEmail(message);
		return new ResponseEntity<>(email,HttpStatus.CREATED);
	}

}
