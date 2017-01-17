package com.goopal.config.bean;

import org.goopal.service.HelloService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2017/1/16
 * @company: (C) Copyright 阳光互信 2017
 * @since: JDK 1.8
 * @description:
 */
public class Register implements ImportBeanDefinitionRegistrar {

    private static final String BEAN_NAME = "myTestBean";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("-----------------ImportBeanDefinitionRegistrar begin");
        if (!registry.containsBeanDefinition(BEAN_NAME)) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(HelloService.class);
            beanDefinition.setSynthetic(true);
//            beanDefinition.setInitMethodName();
//            beanDefinition.setDestroyMethodName();
            registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
        }
    }
}
