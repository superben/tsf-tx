package com.tencent.tsf.trans_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());

        for (int i = 0; i < 5; i++) {
            new Thread(new ConsumerRunner("scott", "tiger", 0)).start();
            new Thread(new ConsumerRunner("tomcat", "jetty", 1000)).start();
            new Thread(new ConsumerRunner("peter", "jason", 6000)).start();
        }
    }
}