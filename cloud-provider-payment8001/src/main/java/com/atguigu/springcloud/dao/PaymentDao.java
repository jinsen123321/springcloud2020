package com.atguigu.springcloud.dao;

        import com.atguigu.springcloud.entities.Payment;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;

/**
 * @author jinsen
 * @create 2020-03-16 18:19
 */
@Mapper
public interface PaymentDao {

    public int create (Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
