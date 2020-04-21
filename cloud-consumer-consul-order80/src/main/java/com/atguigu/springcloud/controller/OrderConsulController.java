package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author jinsen
 * @create 2020-03-18 18:06
 */
@RestController
@Slf4j
public class OrderConsulController {
    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String consumerPayment(){
        String object = restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);

        return object;
    }
}
