package com.tencent.tsf.trans_test.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="service1")
public interface Service1Ex extends Service1 {

}