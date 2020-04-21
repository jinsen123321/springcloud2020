package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @author jinsen
 * @create 2020-03-27 16:33
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderHystrixServiceImp.class)
public interface OrderHystrixService {

    @GetMapping("payment/hustrix/ok/{id}")
    String payment_Ok(@PathVariable("id") Integer id);

    @GetMapping("payment/hustrix/time_out/{id}")
    String payment_TimeOut(@PathVariable("id") Integer id);
}
