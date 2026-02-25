package com.hotking.pcbuilder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:application.yml")
public class AppConfig {
}
