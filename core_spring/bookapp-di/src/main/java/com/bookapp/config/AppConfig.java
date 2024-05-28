package com.bookapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//<context:annotation-config />
//<context:component-scan base-package="com.bookapp" />

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
public class AppConfig {

}
