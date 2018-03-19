package com.tencent.tsf.trans_test.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="service2")
public interface Service2Ex extends Service2 {

}