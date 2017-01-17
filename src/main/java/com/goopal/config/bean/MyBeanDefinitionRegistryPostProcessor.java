package com.goopal.config.bean;

/**
 * Created by leon on 2016/11/8.
 * <p>
 * 实现自己实例化bean并注册为Spring管理
 *
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
/**
 * 实现自己实例化bean并注册为Spring管理
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */

import com.goopal.bean.HelloVillage;
import com.goopal.bean.HelloWorld;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //bean 的名称生成器.
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    /**
     * 先执行：postProcessBeanDefinitionRegistry()方法，
     * 再执行：postProcessBeanFactory()方法。
     *
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

       /*
        * 在这里可以注入bean.
        */
        registerBean(registry, "helloWorld", HelloWorld.class);
        registerBean(registry, "helloVillage", HelloVillage.class);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
        // 这里可以设置属性，例如
//        BeanDefinition bd = beanFactory.getBeanDefinition("dataSourceA");
//        MutablePropertyValues mpv =  bd.getPropertyValues();
//        mpv.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//        mpv.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");
//        mpv.addPropertyValue("username", "root");
//        mpv.addPropertyValue("password", "123456");
    }

    /**
     * 提供公共的注册方法。
     * @param registry
     * @param name
     * @param beanClass
     */
    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
        //可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
        //bean注册的holer类.
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
        //使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
    }

}
