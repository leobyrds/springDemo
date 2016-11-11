package com.goopal.controller;

import com.goopal.service.LocaleMessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by leon on 2016/11/11.
 */
@Controller
@RequestMapping("/i18n")
public class I18nController {
    @Autowired
    private MessageSource messageSource;

    @Resource
    private LocaleMessageSourceService localeMessageSourceService;

    @RequestMapping("/hello")
    public void hello(){
        Locale locale = LocaleContextHolder.getLocale();
//        String msg = messageSource.getMessage("welcome", null,locale);
        String msg = localeMessageSourceService.getMessage("welcome");

        System.out.println(msg);
    }

    @RequestMapping("/changeSessionLanauage")
    public String changeSessionLanauage(HttpServletRequest request, HttpServletResponse response, String lang){
        System.out.println(lang);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if("zh".equals(lang)){
            //代码中即可通过以下方法进行语言设置
//            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
            localeResolver.setLocale(request, response, new Locale("zh", "CN"));
        }else if("en".equals(lang)){
            //代码中即可通过以下方法进行语言设置
//            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
            localeResolver.setLocale(request, response, new Locale("en", "US"));
        }
        return "redirect:/i18n/hello";
    }
}
