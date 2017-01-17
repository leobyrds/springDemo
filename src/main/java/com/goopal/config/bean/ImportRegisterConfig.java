package com.goopal.config.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2017/1/16
 * @company: (C) Copyright 阳光互信 2017
 * @since: JDK 1.8
 * @description:
 */
@Configuration
@Import(Register.class)
public class ImportRegisterConfig {
}
