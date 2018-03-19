package com.tencent.tsf.trans_test.springcloud;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Service2Impl implements Service2 {
    private static final Logger logger = LoggerFactory.getLogger(Service2Impl.class);

    @Override
    public void service2Try(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) throws Throwable {
        logger.info("try, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));
        int number = new Random().nextInt(10);
        if ((number % 2) == 1) {
            throw new Exception("Service2 try fail.");
        }
    }

    @Override
    public boolean service2Confirm(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) {
        logger.info("confirm, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));

        int number = new Random().nextInt(10);
        if ((number % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean service2Cancel(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) {
        logger.info("cancel, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));

        int number = new Random().nextInt(10);
        if ((number % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }



}
