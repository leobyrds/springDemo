package com.goopal.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "common", locations = "classpath:common.properties")
@Data
public class CustomerProperties {
	private String fileFolder;  
}
