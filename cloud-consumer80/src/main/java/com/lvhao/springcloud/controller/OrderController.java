package com.lvhao.springcloud.controller;

import com.lvhao.entity.CommonResult;
import com.lvhao.entity.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvhao09
 * @date 2023/5/13
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RestTemplate restTemplate;

    @Value("${payment.url}")
    private String paymentUrl;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment) {
        log.info("createPayment: {}", payment);
        return restTemplate.postForObject(paymentUrl + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        //getForObject两个参数：请求地址，返回的对象类型
        return restTemplate.getForObject(paymentUrl + "/payment/get/" + id, CommonResult.class);
    }

}
