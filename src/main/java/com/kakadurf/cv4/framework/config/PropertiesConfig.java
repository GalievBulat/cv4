package com.kakadurf.cv4.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:meta.properties")
@PropertySource("classpath:secret.properties")
public class PropertiesConfig {

}
