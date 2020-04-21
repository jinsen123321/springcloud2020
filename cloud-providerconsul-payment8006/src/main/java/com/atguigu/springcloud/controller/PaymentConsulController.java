package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author jinsen
 * @create 2020-03-18 17:50
 */
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentzk(){
        return "springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
