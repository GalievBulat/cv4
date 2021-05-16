package com.kakadurf.cv4.domain.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    @Value("${secret_TWILIO_NUMBER}")
    private String TWILIO_NUMBER;
    @Value("${secret_TWILIO_TOKEN}")
    private String TWILIO_TOKEN ;
    @Value("${secret_TWILIO_SID}")
    private String TWILIO_SID  ;
    public void sendSms(String number, String code){
        Twilio.init(TWILIO_SID, TWILIO_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(number),
                new PhoneNumber(TWILIO_NUMBER),
                "Verification code: " + code)
                .create();
    }
}
