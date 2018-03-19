package com.tencent.tsf.trans_test;

import com.tencent.tsf.trans_test.springcloud.Consumer;
import com.tencent.tsf.trans_test.springcloud.OrderParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);

        Consumer consumer = new Consumer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //for (int i = 0; i < 1; i++) {
            try {
                OrderParams orderParams = new OrderParams();
                orderParams.id = Integer.toString(i);
                orderParams.fromAccount = "fromAccount";
                orderParams.toAccount = "toAccount";
                orderParams.amount = 2;
                orderParams.service1Amount = 1;

                String ret = consumer.callServiceBuy(orderParams);

                logger.info("id: " + orderParams.id + " response: " + ret);

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
