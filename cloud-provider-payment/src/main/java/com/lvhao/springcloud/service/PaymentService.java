package com.lvhao.springcloud.service;

import com.lvhao.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lvhao09
 * @date 2023/3/20
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}