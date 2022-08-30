package com.example.service;

import org.apache.logging.log4j.message.Message;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.GatewayhubConfiguration;
import com.example.entity.SmsRequest;

import ch.qos.logback.classic.Logger;

public class GatewayHubSmsSender implements SmsSender {
	  private static final Logger LOGGER = LoggerFactory.getLogger(GatewayHubSmsSender.class);

	    private final GatewayhubConfiguration gatewayhubConfiguration;

	    @Autowired
	    public GatewayHubSmsSender(GatewayhubConfiguration gatewayhubConfiguration) {
	        this.gatewayhubConfiguration = gatewayhubConfiguration;
	    }

	    @Override
	    public void sendSms(SmsRequest smsRequest) {
	        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
	            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
	            PhoneNumber from = new PhoneNumber(gatewayhubConfiguration.getTrialNumber());
	            String message = smsRequest.getMessage();
	            MessageCreator creator = Message.creator(to, from, message);
	            creator.create();
	            LOGGER.info("Send sms {}", smsRequest);
	        } else {
	            throw new IllegalArgumentException(
	                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
	            );
	        }

	    }

	    private boolean isPhoneNumberValid(String phoneNumber) {
	        // TODO: Implement phone number validator
	        return true;
	    }
	}