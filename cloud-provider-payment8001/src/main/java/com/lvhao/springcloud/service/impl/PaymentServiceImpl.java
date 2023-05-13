package com.lvhao.springcloud.service.impl;

import com.lvhao.springcloud.dao.PaymentDao;
import com.lvhao.springcloud.entity.Payment;
import com.lvhao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lvhao09
 * @date 2023/3/20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}