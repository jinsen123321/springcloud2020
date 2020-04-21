package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHustrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jinsen
 * @create 2020-03-20 16:42
 */
@RestController
@Slf4j
public class PaymentHustrixController {
    @Resource
    private PaymentHustrixService paymentHustrixService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/hustrix/ok/{id}")
    public String payment_Ok(@PathVariable("id") Integer id){
        return paymentHustrixService.payment_Ok(id);
    }
    @GetMapping("payment/hustrix/time_out/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        return paymentHustrixService.payment_TimeOut(id);
    }
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentHustrixService.paymentCircuitBreaker(id);
        log.info("***result:" + result);
        return result;
    }
}
