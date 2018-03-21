package com.tencent.tsf.trans_test.springcloud;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/api/v6/data/service1")
public interface Service1 {

    @RequestMapping(value = "/try", method = RequestMethod.POST)
    String service1Try(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody TestBody params) throws Throwable;

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    String service1Confirm(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody TestBody params) throws Throwable;

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    String service1Cancel(@RequestParam("txId") String txId, @RequestParam("branchId") long branchId, @RequestBody TestBody params) throws Throwable;

}
