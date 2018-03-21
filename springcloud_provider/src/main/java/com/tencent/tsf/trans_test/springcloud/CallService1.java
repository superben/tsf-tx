package com.tencent.tsf.trans_test.springcloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.tsf.transaction.tcc.TransactionType;
import com.tencent.tsf.transaction.tcc.TsfTcc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class CallService1 {

    private static final Logger logger = LoggerFactory.getLogger(CallService1.class);

    @Autowired
    private Service1 service1;

    public static CallService1 callService1;

    @PostConstruct
    public void init() {
        callService1 = this;
    }

    @TsfTcc(serviceName = "service1", type = TransactionType.BRANCH, confirmMethodName = "service1Confirm", cancelMethodName = "service1Cancel")
    public String service1Try(String txId, long branchId, TestBody params) throws Throwable {
        return callService1.service1.service1Try(txId, branchId, params);
    }

    public String service1Confirm(String txId, long branchId, TestBody params) throws Throwable {
        return callService1.service1.service1Confirm(txId, branchId, params);
    }

    public String service1Cancel(String txId, long branchId, TestBody params) throws Throwable {
        return callService1.service1.service1Cancel(txId, branchId, params);
    }
}



