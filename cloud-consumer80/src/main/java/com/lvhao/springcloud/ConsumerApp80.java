package com.lvhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvhao09
 * @date 2023/5/13
 */
@SpringBootApplication
public class ConsumerApp80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp80.class, args);
    }

    @Bean
    // load balancer-aware rest template: 会将url中的域名当做eureka service id解析
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
