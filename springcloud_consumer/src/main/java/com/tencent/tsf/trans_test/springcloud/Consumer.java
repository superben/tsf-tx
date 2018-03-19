package com.tencent.tsf.trans_test.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(ServiceBuy.class);

    @Autowired
    private ServiceBuy serviceBuy;

    public static Consumer consumer;

    @PostConstruct
    public void init() {
        consumer = this;
    }

    public String callServiceBuy(OrderParams params) {
        return consumer.serviceBuy.serviceBuy1(params);
    }

}