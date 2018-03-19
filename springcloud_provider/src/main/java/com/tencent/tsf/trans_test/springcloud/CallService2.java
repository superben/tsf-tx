package com.tencent.tsf.trans_test.springcloud;

import com.tencent.tsf.transaction.tcc.TransactionType;
import com.tencent.tsf.transaction.tcc.TsfTcc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class CallService2 {

    private static final Logger logger = LoggerFactory.getLogger(CallService2.class);

    @Autowired
    private Service2Ex service2;

    public static CallService2 callService2;

    @PostConstruct
    public void init() {
        callService2 = this;
    }

    @TsfTcc(serviceName = "service2", type = TransactionType.BRANCH, confirmMethodName = "service2Confirm", cancelMethodName = "service2Cancel")
    public void service2Try(String txId, long branchId, OrderParams params) throws Throwable {
        callService2.service2.service2Try(txId, branchId, params);
    }

    public boolean service2Confirm(String txId, long branchId, OrderParams params) {
        return callService2.service2.service2Confirm(txId, branchId, params);
    }

    public boolean service2Cancel(String txId, long branchId, OrderParams params) {
        return callService2.service2.service2Cancel(txId, branchId, params);
    }
}
