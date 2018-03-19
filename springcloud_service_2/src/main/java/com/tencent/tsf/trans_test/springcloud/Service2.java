package com.tencent.tsf.trans_test.springcloud;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/api/v6/data/service2")
interface Service2 {

    @RequestMapping(value = "/try", method = RequestMethod.POST)
    void service2Try(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params) throws Throwable;

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    boolean service2Confirm(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params);

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    boolean service2Cancel(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody OrderParams params);
}
