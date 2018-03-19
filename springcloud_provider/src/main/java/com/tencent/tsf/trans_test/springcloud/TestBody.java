package com.tencent.tsf.trans_test.springcloud;

import java.io.Serializable;

class TestBody implements Serializable {
    public String test;

    public TestBody() {}

    public TestBody(String test) {
        this.test = test;
    }
}