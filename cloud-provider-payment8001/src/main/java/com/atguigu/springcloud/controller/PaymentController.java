package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jinsen
 * @create 2020-03-17 11:05
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult Create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("**********插入结果:"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        log.info("**********插入结果:"+payment);

        if(payment != null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,payment);
        }else {
            return new CommonResult(400,"查询失败,查询ID："+id,null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
