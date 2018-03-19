package com.tencent.tsf.trans_test.springcloud;

import java.io.Serializable;

public class OrderParams implements Serializable {
    public String id;
    public String fromAccount;
    public String toAccount;
    public double amount;
    public double service1Amount;

    public TestBody toTestBody() {
        return new TestBody(id);
    }
}