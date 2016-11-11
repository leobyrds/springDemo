package com.goopal.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 *
 * @author   Angel(QQ:412887952)
 */
@Component
@Order(value=1)
public class MyStartupRunner2 implements CommandLineRunner {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 22222222 <<<<<<<<<<<<<");
    }
 
}
