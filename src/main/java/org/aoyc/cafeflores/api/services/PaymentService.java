/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.aoyc.cafeflores.api.stripe.PaymentIntentDTO;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author odraude
 */
public class PaymentService {
    @Value("$(stripe.key.secret)")
    String secretKey;
    
    public PaymentIntent paymentIntent(PaymentIntentDTO dto) throws StripeException{
        Stripe.apiKey = secretKey;
        Map<String,Object> params = new HashMap<>();
        params.put("amount", dto.getAmount());
        params.put("currency", dto.getCurrency());
        params.put("description", dto.getDescription());
        ArrayList payment_method_types = new ArrayList<>();
        payment_method_types.add("card");
        params.put("payment_method_types", payment_method_types);
        return PaymentIntent.create(params);
    }
    
    public PaymentIntent confirm(String id) throws StripeException{
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String,Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent.create(params);
        return paymentIntent;
    }
    
        public PaymentIntent cancel(String id) throws StripeException{
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
