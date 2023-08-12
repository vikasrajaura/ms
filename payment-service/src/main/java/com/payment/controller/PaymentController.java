package com.payment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payment.entity.Payment;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Integer orderId) throws JsonProcessingException {

        return paymentService.findPaymentHistoryByOrderId(orderId);
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {
        return paymentService.savePayment(payment);

    }


}
