package com.example.service;

import com.example.entity.SmsRequest;

public interface SmsSender {
	void sendSms(SmsRequest smsRequest);

}
