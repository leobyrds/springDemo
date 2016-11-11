package com.goopal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

//@EnableRedisHttpSession
//@ServletComponentScan
/**
 Enable mapping of the configuration properties
 There are two ways to enable the population of the configuration properties classes

 A, Add the annotation @EnableConfigurationProperties on one of your configuration classes
    @EnableConfigurationProperties
    @Configuration
    public void useCustomProperties

    @ConfigurationProperties(prefix = "common", locations = "classpath:common.properties")
    @Component
    public class CustomProperties

 B, Add the annotation (@EnableConfigurationProperties(HornetQHealthConfigurationProperties.class) on the bean,
 where you inject the configuration properties class (replace the class name attribute with your own properties class)
    public class CustomProperties

    @Bean
    @ConfigurationProperties(prefix = "com.kfit.company")
    public CompanyProperties3 companyProperties3(){
        returnnew CompanyProperties3();
    }

    @Autowired
    private CompanyProperties3 companyProperties3;
 */
//@EnableConfigurationProperties({CustomerProperties.class})
@EnableAsync
@SpringBootApplication
@MapperScan("com.goopal.mapper")
public class SpringDemoApplication {

	public static void main(String[] args) {
		/**
		 * 设置 spring.devtools.restart.enabled 属性为false，可以关闭该特性。
		 * 可以在application.properties中设置，也可以通过设置环境变量的方式。
		 */
//		System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication springApplication = new SpringApplication();
        //屏蔽命令行访问属性的设置
        springApplication.setAddCommandLineProperties(false);
        springApplication.run(SpringDemoApplication.class, args);
//        SpringApplication.run(SpringDemoApplication.class, args);

	}

    /*@Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setCookieMaxAge(3600);//设置cookie有效期.
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //设置默认区域,
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }*/


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 设置请求地址的参数,默认为：locale
//          lci.setParamName(LocaleChangeInterceptor.DEFAULT_PARAM_NAME);
        return lci;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
