package com.tencent.tsf.trans_test.springcloud;

import com.tencent.tsf.trans_test.App;
import com.tencent.tsf.transaction.tcc.TransactionType;
import com.tencent.tsf.transaction.tcc.TsfTcc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionBuy {
    private static final Logger logger = LoggerFactory.getLogger(TransactionBuy.class);

    @TsfTcc(serviceName = "serviceBuy", type = TransactionType.ROOT, timeout_ms = 6000)
    public String serviceBuy(OrderParams params) throws Throwable {

        CallService1 callService1 = (CallService1) App.context.getBean("callService1");
        callService1.service1Try("", 0, params.toTestBody());

        CallService2 callService2 = (CallService2) App.context.getBean("callService2");
        callService2.service2Try("", 0, params);
        return "";
    }
}