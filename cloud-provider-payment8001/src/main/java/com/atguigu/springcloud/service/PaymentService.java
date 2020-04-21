package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author jinsen
 * @create 2020-03-17 10:59
 */

public interface PaymentService {
    public int create (Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
