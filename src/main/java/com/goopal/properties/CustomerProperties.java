package com.goopal.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 第一：我们使用了@ConfigurationProperties(prefix = "common") 快速注入我们的属性，这里prefix是key的公共部分。
 * 第二：这里我们使用@Component 注解为spring 管理的类，那么在别的类才可以进行注入使用。
 * 第三：在之前的文章中我们并没有使用@Component进行注册为spring 容器中，
 *      而是使用了@EnableConfigurationProperties({WiselySettings.class})  这样的方式进行注入的。这两种方式都可以。
 */
@ConfigurationProperties(prefix = "common", locations = "classpath:common.properties")
@Component
@Data
public class CustomerProperties {
	private String fileFolder;
    private List<String> file;
    //@Max(value=99)
    private int employCount;
    //@NotNull
    private String name;
}
