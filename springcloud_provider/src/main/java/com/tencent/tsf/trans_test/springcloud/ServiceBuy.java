package com.tencent.tsf.trans_test.springcloud;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value="/api/v6/data/serviceBuy")
public interface ServiceBuy {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String serviceBuy1(@RequestBody OrderParams params);

}
