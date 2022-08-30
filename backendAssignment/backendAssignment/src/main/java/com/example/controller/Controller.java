package com.example.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SmsRequest;

import lombok.Value;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

	private final Service service;

	@Autowired
	public Controller(Service service) {
		this.service = service;

	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@PostMapping
	public void sendSms(@Value @RequestBody SmsRequest smsRequest) {
		service.sendSms(smsRequest);
	}
}
