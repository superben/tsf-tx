package com.tencent.tsf.trans_test;

import com.tencent.tsf.trans_test.springcloud.Consumer;
import com.tencent.tsf.trans_test.springcloud.OrderParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ConsumerRunner implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    private String from;
    private String to;
    private Random rnd = new Random();
    private int id;

    public ConsumerRunner(String from, String to, int id) {
        this.from = from;
        this.to = to;
        this.id = id;

        rnd.setSeed(1357924680l);
    }

    @Override
    public void run() {
        Consumer consumer = new Consumer();

//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        for (int i = id; i < 100+id; i++) {
            try {
                OrderParams orderParams = new OrderParams();
                orderParams.id = Integer.toString(i);
                orderParams.fromAccount = from;
                orderParams.toAccount = to;
                orderParams.amount = rnd.nextDouble();
                orderParams.service1Amount = 1;

                String ret = consumer.callServiceBuy(orderParams);

                logger.info("id: " + orderParams.id + " response: " + ret + " Thread: " + Thread.currentThread().getName());

//                Thread.sleep(30000);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

    }
}
