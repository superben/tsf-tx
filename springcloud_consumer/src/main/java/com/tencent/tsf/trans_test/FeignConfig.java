package com.tencent.tsf.trans_test;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class FeignConfig {

    @Bean
    Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }
}
