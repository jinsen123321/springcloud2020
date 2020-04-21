package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author jinsen
 * @create 2020-03-30 14:52
 */
@Component
public class OrderHystrixServiceImp implements OrderHystrixService {
    @Override
    public String payment_Ok(Integer id) {
        return "呜呜呜呜呜 ok错了错了";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "呜呜呜，timeout也错了错了";
    }
}
