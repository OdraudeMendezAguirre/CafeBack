/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.aoyc.cafeflores.api.services.PaymentService;
import org.aoyc.cafeflores.api.stripe.PaymentIntentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author odraude
 */
@RestController
@RequestMapping("/api/stripe")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/intent")
    public ResponseEntity<String> payment(@RequestBody PaymentIntentDTO dto) throws StripeException{
        PaymentIntent paymentIntent = paymentService.paymentIntent(dto);
        String paymentSrt = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentSrt,HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/confirm/{id}")
    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.confirm(id);
        String paymentSrt = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentSrt, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.cancel(id);
        String paymentSrt = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentSrt, HttpStatus.OK);
    }

}
