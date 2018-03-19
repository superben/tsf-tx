package com.tencent.tsf.trans_test.springcloud;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Service1Impl implements Service1 {
    private static final Logger logger = LoggerFactory.getLogger(Service1Impl.class);

    @Override
    public String service1Try(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) throws Throwable {
        logger.info("try, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));
        int number = new Random().nextInt(10);
        return "{\"code\":0}";
//        if ((number % 2) == 1) {
//            throw new Exception("Service1 try fail.");
//        }
    }

    @Override
    public String service1Confirm(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) {
        logger.info("confirm, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));

        int number = new Random().nextInt(10);

        return "{\"code\":0}";
//        if ((number % 2) == 1) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public String service1Cancel(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) {
        logger.info("cancel, txId:" + txId + " branchId:" + branchId + " params:" + JSON.toJSONString(params));

        int number = new Random().nextInt(10);

        return "{\"code\":0}";
//        if ((number % 2) == 1) {
//            return true;
//        } else {
//            return false;
//        }
    }


}
