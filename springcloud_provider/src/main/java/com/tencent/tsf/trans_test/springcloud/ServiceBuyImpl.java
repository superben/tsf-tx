package com.tencent.tsf.trans_test.springcloud;

import com.alibaba.fastjson.JSON;
import com.tencent.tsf.trans_test.App;
import com.tencent.tsf.transaction.tcc.TransactionCancelledException;
import com.tencent.tsf.transaction.tcc.TransactionTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceBuyImpl implements ServiceBuy {
    private static final Logger logger = LoggerFactory.getLogger(ServiceBuyImpl.class);

    private TransactionBuy transactionBuy = (TransactionBuy) App.context.getBean("transactionBuy");

    @Override
    public String serviceBuy1(@RequestBody OrderParams params) {
        logger.info("serviceBuy params:" + JSON.toJSONString(params));

        try {
            transactionBuy.serviceBuy(params);
        } catch (TransactionCancelledException e) {
            logger.info("TransactionCancelledException:" + e.getMessage()/* + " cause:" + e.getCause().getClass() + " msg:" + e.getCause().getMessage()*/);
            return "request canceled.";
        } catch (TransactionTimeoutException e) {
            logger.info("TransactionTimeoutException:" + e.getMessage()/* + " cause:" + e.getCause().getClass() + " msg:" + e.getCause().getMessage()*/);
            return "request timeout.";
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return "request exception.";
        }
        logger.info("succ!");
        return "request succ.";
    }

}
