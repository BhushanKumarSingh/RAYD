package com.example.repair.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@Component
public class StripeClientService {
	@Autowired
    StripeClientService() {
        Stripe.apiKey = "sk_test_NI2GhDLbSsJqLFoQ7fGcavmx00aZ4EWZWK";
    }

    public Charge chargeCreditCard(String token, double amount) throws InvalidRequestException, AuthenticationException, APIConnectionException, CardException, APIException {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", "inr");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
	
}
